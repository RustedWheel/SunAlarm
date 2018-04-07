package com.a1.compsci702.sunalarm;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.Alarm.AlarmType;
import com.a1.compsci702.sunalarm.Exceptions.NoConnectionException;
import com.a1.compsci702.sunalarm.Utilities.DateConverter;
import com.a1.compsci702.sunalarm.Utilities.Storage;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final static int ALL_PERMISSIONS_RESULT = 101;
    private final String TAG = "MainActivity";
    private ArrayList<String> permissions = new ArrayList<>();
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ListView alarmListView;
    private FloatingActionButton mAddAlarm;
    private Button clearCacheButton;
    private boolean canGetLocation = true;

    private ArrayList<Alarm> _alarms;

    private ArrayList<Integer> alarmIds;
    private ArrayAdapter<Integer> _alarmAdapter;
    private Storage storage;
    private RelativeLayout loadingScreen;
    private boolean attemptedToCached = false;

    private final static int PICK_ALARM_TIME = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = new Storage();

        askForPermission();
        loadAlarms();
        setUpUIComponents();

        if (!(permissionsToRequest.size() > 0) && !attemptedToCached) {
            attemptedToCached = true;
            cacheDates();
        }
    }

    private void askForPermission() {
        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionsToRequest = getUngrantedPermissions(permissions);

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

        loadingScreen = findViewById(R.id.loading_screen);

        mAddAlarm = findViewById(R.id.add_alarm);

        mAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button Pressed.");

                Intent newAlarmIntent = new Intent(v.getContext(), AddAlarmActivity.class);
                startActivityForResult(newAlarmIntent, PICK_ALARM_TIME);
            }
        });

        alarmListView = findViewById(R.id.alarmList);

        // Used for testing
        _alarmAdapter = new ArrayAdapter(this, R.layout.list_item, _alarms);

        alarmListView.setAdapter(_alarmAdapter);

        alarmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = ((TextView) view).getText().toString();

                Toast.makeText(getApplicationContext(), "Alarm + " + text + " deleted!", Toast.LENGTH_LONG).show();

            }

        });

        clearCacheButton = findViewById(R.id.clear_cache_button);
        clearCacheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage.removeAllSunriseTime(MainActivity.this);
            }
        });
    }

    /**
     * Load all the alarm objects stored inside SharedPreference
     */
    private void loadAlarms() {

        SharedPreferences alarmsStorage = getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);

        _alarms = new ArrayList<>();
        alarmIds = new ArrayList<>();

        Map<String, ?> allExistingAlarmEntries = alarmsStorage.getAll();
        for (Map.Entry<String, ?> alarm : allExistingAlarmEntries.entrySet()) {

            Gson gson = new Gson();
            String json = alarm.getValue().toString();
            Alarm obj = gson.fromJson(json, Alarm.class);

            _alarms.add(obj);
            alarmIds.add(obj.getId());
        }

    }

    private ArrayList getUngrantedPermissions(ArrayList<String> permissionsWanted) {
        ArrayList result = new ArrayList();

        for (String permission : permissionsWanted) {
            if (!hasPermission(permission)) {
                result.add(permission);
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
                } else {
                    Log.d(TAG, "can now get location");
                    canGetLocation = true;
                    if (!attemptedToCached) {
                        Log.d(TAG, "now caching dates");
                        attemptedToCached = true;
                        cacheDates();
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");

        switch (requestCode) {
            case PICK_ALARM_TIME:
                // Make sure the request was successful
                if (resultCode == RESULT_OK) {
                    String alarmTime = data.getStringExtra("alarmTime");

                    String[] splitResult = alarmTime.split(":");

                    String offsetSign = splitResult[0];
                    int hour = Integer.parseInt(splitResult[1]);
                    int minute = Integer.parseInt(splitResult[2]);

                    //get sunrise time for tomorrow
                    //calculate offset time
                    //set alarm
                    Calendar today = Calendar.getInstance();
                    today.add(Calendar.DATE, 1);
                    String dateTomorrow = DateConverter.dateToString(today.getTime());
                    Log.d(TAG, "Date tomorrow is : " + dateTomorrow);

                    //change later on to set date of alarm
                    SharedPreferences sunriseStorage = getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);
                    Date nextSunrise = new Date(sunriseStorage.getLong(dateTomorrow, 0L));

                    Log.d(TAG, "Sunrise tomorrow is : " + nextSunrise);

                    Calendar c = DateConverter.convertDateToCalendar(nextSunrise);

                    if (offsetSign.equals("-")) {
                        hour = -hour;
                        minute = -minute;
                    }

                    c.add(Calendar.HOUR, hour);
                    c.add(Calendar.MINUTE, minute);

                    Log.d(TAG, c.toString());

                    String snoozeString = data.getStringExtra("snooze");
                    boolean isSnooze = Boolean.valueOf(snoozeString);
                    Log.d(TAG, "snooze = " + isSnooze);

                    String alarmName = data.getStringExtra("alarmName");
                    addAlarm(alarmName, c.getTime(), isSnooze, false, AlarmType.type.sunrise);

                    Log.d(TAG, "protected void onActivityResult() " + alarmTime);

                    // test
                    String repeat = data.getStringExtra("repeat");
                    Log.d(TAG, "repeat = " + repeat);
                    //test
                }
                break;
        }
    }


    private void getSunriseTime(Date date, int numDays) {

        if (canGetLocation) {

            CurrentLocation currentLocation = new CurrentLocation(getApplicationContext());

            try {

                Location location = currentLocation.getCurrentLocation();

                Double latitude = location.getLatitude();
                Double longitude = location.getLongitude();

                Log.d(TAG, "Sunrise !  Location - Latitude: " + latitude + " Longitude: " + longitude);

                FetchSunriseData sunriseTask = new FetchSunriseData(location, date, numDays);
                sunriseTask.execute();
            } catch (NoConnectionException e) {
                showGPSSettingsAlert();
            } catch (SecurityException e) {
                showPermissionDenied();
            }
        }
    }

    private void cacheDates() {

        Log.d(TAG, "Cache dates");

        SharedPreferences sunriseStorage = getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);

        Calendar c = Calendar.getInstance();
        int today = Integer.parseInt(DateConverter.dateToString(c.getTime()));

        Map<String, ?> allEntries = sunriseStorage.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if (today > Integer.parseInt(entry.getKey())) {
                storage.removeSunriseTime(this, entry.getKey());
            } else {
                Log.d(TAG, "Future date : " + entry.getKey());
            }
        }

        getSunriseTime(c.getTime(), 7);

    }

    private class FetchSunriseData extends AsyncTask<Void, Void, Date> {

        private Location _location;
        private Date _alarmDate;
        private int _numDays;

        public FetchSunriseData(Location location, Date alarmDate, int numDays) {
            _location = location;
            _alarmDate = alarmDate;
            _numDays = numDays;
        }

        @Override
        protected Date doInBackground(Void... params) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    alarmListView.setVisibility(View.INVISIBLE);
                    mAddAlarm.setVisibility(View.INVISIBLE);
                    loadingScreen.setVisibility(View.VISIBLE);
                }
            });

            SunriseTime sunriseTime = new SunriseTime();
            SharedPreferences sunriseStorage = getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);

            try {
                for (int i = 0; i <= _numDays; i++) {
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.DATE, i);
                    //check if already in cache
                    if (sunriseStorage.contains(DateConverter.dateToString(c.getTime()))) {
                        Log.d(TAG, "Already cached : " + c.getTime());
                    } else {
                        Log.d(TAG, "Accessing date : " + c.getTime());
                        Date date = sunriseTime.getSunriseTime(_location, c.getTime());
                        storage.saveSunriseTime(MainActivity.this, date);
                    }
                }

                return new Date();
            } catch (IOException e) {

                Log.e(TAG, "Failed to fetch sunrise time!");
                return null;
            }
        }

        @Override
        protected void onPostExecute(Date result) {
            if (result != null) {
                super.onPostExecute(result);
                Log.d(TAG, "FINISHED CACHING DATA");

            } else {
                Toast.makeText(getApplicationContext(), "Unable to connect to server", Toast.LENGTH_LONG).show();
            }

            alarmListView.setVisibility(View.VISIBLE);
            mAddAlarm.setVisibility(View.VISIBLE);
            loadingScreen.setVisibility(View.INVISIBLE);
        }

    }

    /**
     * @param date Time for alarm
     */
    public void addAlarm(String name, Date date, boolean isSnooze, boolean isRepeat, AlarmType.type type) {

        if (date.getTime() < Calendar.getInstance().getTime().getTime()) {
            Toast.makeText(getApplicationContext(), "Unable to make an alarm in the past", Toast.LENGTH_LONG).show();
        } else {

            int alarmID = storage.getNextAlarmID(this);

            Alarm alarm = new Alarm(name, alarmID, date, isSnooze, isRepeat, type);
            alarm.setAlarm(getApplicationContext());

            Log.d(TAG, "alarm set " + date.toString() + " ALARM ID: " + alarmID);
            Toast.makeText(getApplicationContext(), date.toString(), Toast.LENGTH_LONG).show();

            storage.saveAlarm(this, alarm);

            // Add the alarm
            _alarms.add(alarm);

            // Add the alarm ID if needed
            // Delete this line if to use the alarm class as the adapter
            alarmIds.add(alarmID);
            _alarmAdapter.notifyDataSetChanged();
        }
    }


    public void cancelAlarm(Alarm alarm, int index) {

        storage.deleteAlarm(this, alarm.getId());

        alarm.cancelAlarm(getApplicationContext());

        _alarms.remove(index);

        // Again delete this if not needed
        alarmIds.remove(index);

        _alarmAdapter.notifyDataSetChanged();
    }


}
