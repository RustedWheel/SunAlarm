package com.a1.compsci702.sunalarm;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.a1.compsci702.sunalarm.Exceptions.NoConnectionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private final static int ALL_PERMISSIONS_RESULT = 101;
    private final String TAG = "MainActivity";
    private ArrayList<String> permissions = new ArrayList<>();
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private FloatingActionButton mAddAlarm;
    private boolean canGetLocation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        askForPermission();
        setUpUIComponents();

    }

    private void askForPermission() {
        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (permissionsToRequest.size() > 0) {

                ActivityCompat.requestPermissions(MainActivity.this, permissionsToRequest.toArray(new String[permissionsToRequest.size()]),
                        ALL_PERMISSIONS_RESULT);
                Log.d(TAG, "Permission requests");
                canGetLocation = false;
            }

        }
    }

    private void setUpUIComponents() {

        mAddAlarm = findViewById(R.id.add_alarm);

        mAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button Pressed.");
                getSunriseTime();

                Intent newAlarmIntent = new Intent(v.getContext(), AddAlarmActivity.class);
                startActivity(newAlarmIntent);
            }
        });

    }


    private ArrayList findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList result = new ArrayList();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }


    private boolean hasPermission(String permission) {
        if (canAskPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canAskPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case ALL_PERMISSIONS_RESULT:
                Log.d(TAG, "onRequestPermissionsResult");
                for (String perms : permissionsToRequest) {
                    if (!hasPermission(perms)) {
                        permissionsRejected.add(perms);
                    }
                }

                if (permissionsRejected.size() > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                ActivityCompat.requestPermissions(MainActivity.this, permissionsRejected.toArray(
                                                        new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    },
                                    new DialogInterface.OnCancelListener() {
                                        @Override
                                        public void onCancel(DialogInterface dialogInterface) {
                                            finish();
                                        }
                                    });
                            return;
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener, DialogInterface.OnCancelListener cancelListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setOnCancelListener(cancelListener)
                .create()
                .show();
    }

    public void showGPSSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("GPS is not Enabled!");
        alertDialog.setMessage("Do you want to turn on GPS?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    public void showPermissionDenied() {
        Toast.makeText(getApplicationContext(), "No Permission to get location!", Toast.LENGTH_LONG).show();
    }


    private void getSunriseTime() {

        if (canGetLocation) {

            CurrentLocation currentLocation = new CurrentLocation(getApplicationContext());

            try {

                Location location = currentLocation.getCurrentLocation();

                Double latitude = location.getLatitude();
                Double longitude = location.getLongitude();

                Toast.makeText(getApplicationContext(), "Sunrise !  Location - Latitude: " + latitude + " Longitude: " + longitude, Toast.LENGTH_LONG).show();

                SunriseTime sunriseTime = new SunriseTime();

                Calendar cal = Calendar.getInstance();
                cal.set(2018, Calendar.APRIL, 9); //Year, month, day of month, hours, minutes and seconds
                Date date = cal.getTime();

                FetchSunriseData sunriseTask = new FetchSunriseData(location, date);
                sunriseTask.execute();

                /*alarm = new Alarm();
                alarm.setAlarm(MainActivity.this, seconds);*/

            } catch (NoConnectionException e) {
                showGPSSettingsAlert();
            } catch (SecurityException e) {
                showPermissionDenied();
            }

        }
    }


    private class FetchSunriseData extends AsyncTask<Void, Void, Date> {

        private Location _location;
        private Date _alarmDate;

        public FetchSunriseData(Location location, Date alarmDate) {
            _location = location;
            _alarmDate = alarmDate;
        }

        @Override
        protected Date doInBackground(Void... params) {

            SunriseTime sunriseTime = new SunriseTime();

            try {
                Date date = sunriseTime.getSunriseTime(_location, _alarmDate);

                return date;
            } catch (IOException e) {

                Log.e(TAG, "Failed to fetch sunrise time!");
                return null;
            }
        }

        @Override
        protected void onPostExecute(Date result) {
            super.onPostExecute(result);
            Log.d(TAG, "JSON: " + result.toString());
        }
    }
}
