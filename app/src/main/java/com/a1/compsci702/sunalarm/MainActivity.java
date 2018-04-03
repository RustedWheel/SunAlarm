package com.a1.compsci702.sunalarm;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.a1.compsci702.sunalarm.Exceptions.NoConnectionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final static int ALL_PERMISSIONS_RESULT = 101;
    private final String TAG = "MainActivity";
    private ArrayList<String> permissions = new ArrayList<>();
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ListView alarmListView;
    private FloatingActionButton mAddAlarm;
    private boolean canGetLocation = true;
    private ArrayList<Integer> alarmIds;
    private Hashtable<String, Long> sunriseTimes = new Hashtable<String, Long>(); //remove when cache is done

/*
    private String offsetSign;
    private int hour;
    private int minute;
*/


    private final static int PICK_ALARM_TIME = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        askForPermission();
        setUpUIComponents();
        loadAlarms();
        cacheDates();
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

                Intent newAlarmIntent = new Intent(v.getContext(), AddAlarmActivity.class);
                startActivityForResult(newAlarmIntent, PICK_ALARM_TIME);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");

        // Check which request we're responding to
        if (requestCode == PICK_ALARM_TIME) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("addAlarmResult");

                String[] splitResult = result.split(":");

                String offsetSign = splitResult[0];
                int hour = Integer.parseInt(splitResult[1]);
                int minute = Integer.parseInt(splitResult[2]);

                //get sunrise time for tomorrow
                //calculate offset time
                //set alarm
                Calendar today = Calendar.getInstance();
                today.add(Calendar.DATE, 1);
                String dateTomorrow = dateToString(today.getTime());
                Log.d(TAG, "Date tomorrow is : " + dateTomorrow);

                Date nextSunrise = new Date(sunriseTimes.get(dateTomorrow));

                Log.d(TAG, "Sunrise tomorrow is : " + nextSunrise);

                Calendar c = convertDateToCalendar(nextSunrise);

                if (offsetSign.equals("-")) {
                    hour = -hour;
                    minute = -minute;
                }

                    c.add(Calendar.HOUR, hour);
                    c.add(Calendar.MINUTE, minute);

                    Log.d(TAG,c.toString());
                    setAlarm(c.getTime(), 1);

                Log.d(TAG, "protected void onActivityResult() " + result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                Log.e(TAG, "resultCode == " + Activity.RESULT_CANCELED);
            }
        }
    }

    private void loadAlarms(){

        SharedPreferences alarmsStorage = getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);

        alarmIds = new ArrayList<>();

        Map<String, ?> allExistingAlarmEntries =alarmsStorage.getAll();
        for (Map.Entry<String, ?> alarmId : allExistingAlarmEntries.entrySet()) {

            alarmIds.add(Integer.valueOf(alarmId.getKey()));

        }

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


    private void getSunriseTime(Date date) {

        if (canGetLocation) {

            CurrentLocation currentLocation = new CurrentLocation(getApplicationContext());

            try {

                Location location = currentLocation.getCurrentLocation();

                Double latitude = location.getLatitude();
                Double longitude = location.getLongitude();

                //Toast.makeText(getApplicationContext(), "Sunrise !  Location - Latitude: " + latitude + " Longitude: " + longitude, Toast.LENGTH_LONG).show();
                Log.d(TAG, "Sunrise !  Location - Latitude: " + latitude + " Longitude: " + longitude);

                FetchSunriseData sunriseTask = new FetchSunriseData(location, date);
                sunriseTask.execute();
            } catch (NoConnectionException e) {
                showGPSSettingsAlert();
            } catch (SecurityException e) {
                showPermissionDenied();
            }
        }
    }

    private void cacheDates() {

        for(int i = 1; i <= 7; i++) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, i);
            getSunriseTime(c.getTime());
        }
    }

    private String dateToString(Date date) {
        return date.getYear() + "-" + date.getMonth() + "-" + date.getDay();
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
            if (result != null) {
                super.onPostExecute(result);
                Log.d(TAG, "JSON: " + result.toString());
                sunriseTimes.put(dateToString(result), result.getTime());


            } else {
                Toast.makeText(getApplicationContext(), "Unable to connect to server", Toast.LENGTH_LONG).show();
            }
        }

    }

    /**
     *
     * @param date Time for alarm
     * @param alarmID
     */
    public void setAlarm(Date date, int alarmID) {
        /*AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);*/
        //am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pendingIntent); // Millisec * Second * Minute
        //am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()* seconds * 1000, pendingIntent);

        Calendar c = convertDateToCalendar(date);

        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, alarmID, intent,0);
        AlarmManager am = (AlarmManager)getSystemService(this.ALARM_SERVICE);
        // am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + seconds * 1000, pendingIntent );
        am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent );
        Log.d(TAG, "alarm set " + date.toString());
        Toast.makeText(getApplicationContext(), date.toString(), Toast.LENGTH_LONG).show();
        saveToStorage(alarmID);
    }


    public void cancelAlarm(int alarmID) {
        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(this, alarmID, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }


    private Calendar convertDateToCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    private void saveToStorage(int alarmID){

        SharedPreferences alarmsStorage = getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmsStorage.edit();
        editor.putInt(String.valueOf(alarmID), alarmID);
        editor.apply();

    }
}
