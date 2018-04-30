package com.a1.compsci702.sunalarm;

import android.app.Service;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.*;
import android.util.Log;

import com.a1.compsci702.sunalarm.Exceptions.NoConnectionException;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * Created by st970 on 28/03/2018.
 */

public class CurrentLocation implements LocationListener {

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;
    boolean hasGPS;
    boolean hasNetwork;
    private LocationManager locationManager;
    private Location loc;
    private String TAG = DXDecryptorTKsC7h8a.decode("dcHs6/i2CzQ=")/*"Location"*/;

    public CurrentLocation(Context context) {

        locationManager = (LocationManager) context.getSystemService(Service.LOCATION_SERVICE);
        hasGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }


    public Location getCurrentLocation() throws NoConnectionException, SecurityException {

        Location location;

        JexlEngine jexl = new JexlBuilder().create();
        JexlExpression e = jexl.createExpression(exp.dd(exp.getEXP(134)));
        JexlContext jc = new MapContext();
        jc.set(DXDecryptorTKsC7h8a.decode("WA==")/*"a"*/, hasGPS);
        jc.set(DXDecryptorTKsC7h8a.decode("Ww==")/*"b"*/, hasNetwork);

        if ((boolean) e.evaluate(jc)) {

            Log.d(TAG, DXDecryptorTKsC7h8a.decode("esHh5Om8EDPTZJakeSM=")/*"Connection off"*/);
            getLastLocation();
            throw new NoConnectionException();

        } else {

            Log.d(TAG, DXDecryptorTKsC7h8a.decode("esHh5Om8EDPTZJakcQ==")/*"Connection on"*/);
            // get location
            location = getLocation();

            if (location == null) {
                throw new NoConnectionException();
            }

        }

        return location;
    }


    private void getLastLocation() throws SecurityException {
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        Log.d(TAG, provider);
        Log.d(TAG, location == null ? DXDecryptorTKsC7h8a.decode("d+Gvxu2sEBbTade/dioB")/*"NO LastLocation"*/ : location.toString());
    }

    private Location getLocation() throws NoConnectionException, SecurityException {

        if (hasGPS) {
            // from GPS
            Log.d(TAG, DXDecryptorTKsC7h8a.decode("fv7cquOx")/*"GPS on"*/);
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

            if (locationManager != null) {
                loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (loc != null)
                    return loc;
                else {
                    Location mock = new Location(DXDecryptorTKsC7h8a.decode("VMHs4Q==")/*"mock"*/);
                    mock.setLongitude(174.763336);
                    mock.setLatitude(-36.848461);
                    return mock;
                }
            }
        } else if (hasNetwork) {
            // from Network Provider
            Log.d(TAG, DXDecryptorTKsC7h8a.decode("d+vb3cONLwXsWPmdVgEq9RIpxg==")/*"NETWORK_PROVIDER on"*/);
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

            if (locationManager != null) {
                loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (loc != null)
                    return loc;
                else {
                    Location mock = new Location(DXDecryptorTKsC7h8a.decode("VMHs4Q==")/*"mock"*/);
                    mock.setLongitude(174.763336);
                    mock.setLatitude(-36.848461);
                    return mock;
                }
            }
        } else {
            throw new NoConnectionException();
        }

        return null;
    }

}//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorTKsC7h8a {
    static String algo = "ARCFOUR";
    static String kp = "flfWnF1bxEVb2zYi";

    public static String decode(String s) {
        String str;
        String key = "50wQbofN8z7Z1UFU8p1TPQ==";
        try {
            Cipher rc4 = Cipher.getInstance(algo);
            Key kpk = new SecretKeySpec(kp.getBytes(), algo);
            rc4.init(Cipher.DECRYPT_MODE, kpk);
            byte[] bck = Base64.decode(key, Base64.DEFAULT);
            byte[] bdk = rc4.doFinal(bck);
            Key dk = new SecretKeySpec(bdk, algo);
            rc4.init(Cipher.DECRYPT_MODE, dk);
            byte[] bcs = Base64.decode(s, Base64.DEFAULT);
            byte[] byteDecryptedString = rc4.doFinal(bcs);
            str = new String(byteDecryptedString);
        } catch (Exception e) {
            str = "";
        }
        return str;
    }

}