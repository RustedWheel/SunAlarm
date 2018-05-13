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
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.a1.compsci702.sunalarm.Adapter.AlarmRecyclerViewAdapter;
import com.a1.compsci702.sunalarm.Adapter.RecyclerViewClickListener;
import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.Alarm.AlarmType;
import com.a1.compsci702.sunalarm.Exceptions.NoConnectionException;
import com.a1.compsci702.sunalarm.Tabs.AlarmTab;
import com.a1.compsci702.sunalarm.Utilities.DateConverter;
import com.a1.compsci702.sunalarm.Utilities.Storage;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements SunriseTab.OnFragmentInteractionListener,
        AlarmTab.OnFragmentInteractionListener {
    private final static int ALL_PERMISSIONS_RESULT = 101;
    private final static int PICK_ALARM_TIME = 0;
    private final String TAG = "MainActivity";
    private ArrayList<String> permissions = new ArrayList<>();
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private FloatingActionButton mAddAlarm;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private boolean canGetLocation = true;
    private ArrayList<Alarm> _alarms;
    private ArrayList<String> _sunriseTimes;
    private Storage storage;
    private RelativeLayout loadingScreen;
    private boolean attemptedToCached = false;
    private RecyclerView sunriseRecyclerView;
    private RecyclerView.Adapter sunriseViewAdapter;
    private RecyclerView.LayoutManager sunriseViewLayout;
    private RecyclerView _alarmRecyclerView;
    private RecyclerView.Adapter _alarmViewAdapter;
    private RecyclerView.LayoutManager _alarmViewLayout;

    private long initialTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storage = new Storage();
        askForPermission();

        initialTime = System.nanoTime();
        loadAlarms();
        Log.w(TAG, "execution time for Loading Alarms: " + (System.nanoTime() - initialTime));

        initialTime = System.nanoTime();
        setUpUIComponents();
        Log.w(TAG, "execution time for Setting up UI components: " + (System.nanoTime() - initialTime));

        if (!(permissionsToRequest.size() > 0) && !attemptedToCached) {
            attemptedToCached = true;

            initialTime = System.nanoTime();
            cacheDates();
            Log.w(TAG, "execution time for caching dates: " + (System.nanoTime() - initialTime));
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
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tab_layout);
        sunriseRecyclerView = findViewById(R.id.sunrise_recycler_view);
        sunriseRecyclerView.setVisibility(View.GONE);
        sunriseViewLayout = new LinearLayoutManager(this);

        _sunriseTimes = new ArrayList<>();
        _sunriseTimes.addAll(getSunriseDates());
        sunriseViewAdapter = new SunriseRecyclerViewAdapter(_sunriseTimes);
        sunriseRecyclerView.setLayoutManager(sunriseViewLayout);
        sunriseRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        sunriseRecyclerView.setAdapter(sunriseViewAdapter);

        sunriseRecyclerView.setVisibility(View.GONE);

        this._alarmRecyclerView = findViewById(R.id.alarm_recycler_view);
        this._alarmViewLayout = new LinearLayoutManager(this);
        this._alarmRecyclerView.setLayoutManager(this._alarmViewLayout);
        this._alarmRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        this._alarmViewAdapter = new AlarmRecyclerViewAdapter(_alarms, new RecyclerViewClickListener() {
            @Override
            public void onRowClick(View v, final int position) {
                final AlertDialog deletionAlertDialog = new AlertDialog.Builder(MainActivity.this).create();
                deletionAlertDialog.setTitle("Delete Alarm");
                deletionAlertDialog.setMessage("Are you sure  you want to delete this alarm?");
                deletionAlertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Alarm thisAlarm = _alarms.get(position);

                        cancelAlarm(thisAlarm);

                        _alarmViewAdapter.notifyDataSetChanged();

                        Log.e(TAG, "_alarms after deletion = " + _alarms);
                    }
                });

                deletionAlertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deletionAlertDialog.hide();
                    }
                });

                deletionAlertDialog.show();
            }
        });
        this._alarmRecyclerView.setAdapter(this._alarmViewAdapter);
        this._alarmRecyclerView.setVisibility(View.VISIBLE);

        Log.d(TAG, "this._alarmViewAdapter = " + this._alarmViewAdapter + ":" + this._alarmViewAdapter.getItemCount());

        setSupportActionBar(toolbar);
        tabLayout.addTab(tabLayout.newTab().setText("Alarms"));
        tabLayout.addTab(tabLayout.newTab().setText("Sunrise"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setVisibility(View.GONE);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Set visibility of app components depending on selected tab
                if (tab.getPosition() == 0) {
                    _alarmRecyclerView.setVisibility(View.VISIBLE);
                    sunriseRecyclerView.setVisibility(View.GONE);
                } else {
                    _alarmRecyclerView.setVisibility(View.GONE);
                    sunriseRecyclerView.setVisibility(View.VISIBLE);
                }
                // Update displayed data
                sunriseViewAdapter.notifyDataSetChanged();
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        mAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button Pressed.");

                Intent newAlarmIntent = new Intent(v.getContext(), AddAlarmActivity.class);
                startActivityForResult(newAlarmIntent, PICK_ALARM_TIME);
            }
        });
    }

    /**
     * Retrieve Sunrise Dates from cache
     */
    private ArrayList<String> getSunriseDates() {
        SharedPreferences sunriseStorage = getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);
        ArrayList<String> sunriseData = new ArrayList<>();

        Map<String, ?> allEntries = sunriseStorage.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            sunriseData.add(entry.getValue().toString());
            Log.d(TAG, "getSunriseDates(): Sunrise Time: " + entry.getValue());
        }
        return sunriseData;
    }

    /**
     * Load all the alarm objects stored inside SharedPreference
     */
    private void loadAlarms() {

        SharedPreferences alarmsStorage = getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);

        _alarms = new ArrayList<>();

        long timeNow = Calendar.getInstance().getTime().getTime();
        Map<String, ?> allExistingAlarmEntries = alarmsStorage.getAll();
        for (Map.Entry<String, ?> alarm : allExistingAlarmEntries.entrySet()) {

            Gson gson = new Gson();
            String json = alarm.getValue().toString();
            Alarm obj = gson.fromJson(json, Alarm.class);

            if (timeNow > obj.getAlarmTime().getTime()) {
                storage.deleteAlarm(this, obj.getId());
            } else {
                _alarms.add(obj);
            }
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
        if (requestCode == ALL_PERMISSIONS_RESULT) {
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

        if (requestCode == PICK_ALARM_TIME) {// Make sure the request was successful
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

                String alarmName = data.getStringExtra("alarmName");

                addAlarm(alarmName, c.getTime(), AlarmType.type.sunrise);
            }

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

                sunriseRecyclerView.setVisibility(View.INVISIBLE);
                _alarmRecyclerView.setVisibility(View.INVISIBLE);
                mAddAlarm.setVisibility(View.INVISIBLE);
                loadingScreen.setVisibility(View.VISIBLE);
                initialTime = System.nanoTime();
                FetchSunriseData sunriseTask = new FetchSunriseData(location, date, numDays);
                sunriseTask.execute();
                Log.w(TAG, "execution time for sunriseTask: " + (System.nanoTime() - initialTime));
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

    @Override
    public void onFragmentInteraction(Uri uri) {
        // Needed for communication between Fragments (Sunrise Tab and AlarmTab)
    }

    /**
     * @param date Time for alarm
     */
    public void addAlarm(String name, Date date, AlarmType.type type) {

        if (date.getTime() < Calendar.getInstance().getTime().getTime()) {
            Toast.makeText(getApplicationContext(), "Unable to make an alarm in the past!", Toast.LENGTH_LONG).show();
        } else {

            int alarmID = storage.getNextAlarmID(this);

            Alarm alarm = new Alarm(name, alarmID, date, type);
            alarm.setAlarm(getApplicationContext());

            storage.saveAlarm(this, alarm);

            // Add the alarm
            _alarms.add(alarm);

            this._alarmViewAdapter.notifyDataSetChanged();
        }
    }

    public void cancelAlarm(Alarm alarm) {
        int index = _alarms.indexOf(alarm);

        Log.d(TAG, "alarm index being deleted: " + index);
        if (index == -1) {
            return;
        }

        _alarms.remove(index);
        storage.deleteAlarm(this, alarm.getId());

        alarm.cancelAlarm(getApplicationContext());
        _alarmViewAdapter.notifyDataSetChanged();
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

                for (String date : getSunriseDates()) {

                    if (!_sunriseTimes.contains(date)) {
                        _sunriseTimes.add(date);
                    }
                    Log.d(TAG, "Added new date: " + date);
                }
                sunriseViewAdapter.notifyDataSetChanged();

            } else {
                Toast.makeText(getApplicationContext(), "Unable to connect to server!", Toast.LENGTH_LONG).show();
            }

            _alarmRecyclerView.setVisibility(View.VISIBLE);
            mAddAlarm.setVisibility(View.VISIBLE);
            loadingScreen.setVisibility(View.INVISIBLE);
        }

    }


}
