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
import android.util.Base64;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public class CurrentLocation implements LocationListener {

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = di(new String[]{"MTEwMDAx", "MTEwMDAw"});

    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    boolean hasGPS;

    boolean hasNetwork;

    private LocationManager locationManager;

    private Location loc;

    private String TAG = ds(new String[]{DXDecryptorkyA23o48.decode("dSNGig==")/*"TA=="*/, DXDecryptorkyA23o48.decode("QxVGig==")/*"bw=="*/, DXDecryptorkyA23o48.decode("eBVGig==")/*"Yw=="*/, DXDecryptorkyA23o48.decode("eDNGig==")/*"YQ=="*/, DXDecryptorkyA23o48.decode("RSNGig==")/*"dA=="*/, DXDecryptorkyA23o48.decode("QDNGig==")/*"aQ=="*/, DXDecryptorkyA23o48.decode("QxVGig==")/*"bw=="*/, DXDecryptorkyA23o48.decode("QwVGig==")/*"bg=="*/});

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
        jc.set(DXDecryptorkyA23o48.decode("QA==")/*"a"*/, hasGPS);
        jc.set(DXDecryptorkyA23o48.decode("Qw==")/*"b"*/, hasNetwork);
        if ((boolean) e.evaluate(jc)) {
            getLastLocation();
            throw new NoConnectionException();
        } else {
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
    }

    private Location getLocation() throws NoConnectionException, SecurityException {
        if (hasGPS) {
            // from GPS
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
            if (locationManager != null) {
                loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (loc != null)
                    return loc;
                else {
                    Location mock = new Location(DXDecryptorkyA23o48.decode("TA0Y3A==")/*"mock"*/);
                    mock.setLongitude(174.763336);
                    mock.setLatitude(-36.848461);
                    return mock;
                }
            }
        } else if (hasNetwork) {
            // from Network Provider
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
            if (locationManager != null) {
                loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (loc != null)
                    return loc;
                else {
                    Location mock = new Location(DXDecryptorkyA23o48.decode("TA0Y3A==")/*"mock"*/);
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

    public static int di(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            byte[] d = Base64.decode(s, Base64.DEFAULT);
            String n = new String(d);
            sb.append(Integer.parseInt(n, 2) - 48);
        }
        return Integer.parseInt(sb.toString());
    }

    public static String ds(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            byte[] d = Base64.decode(s, Base64.DEFAULT);
            String n = new String(d);
            sb.append(n);
        }
        return sb.toString();
    }

    public static int NGhlYWQ(String[] a) {
        int sb = 0;
        String g = DXDecryptorkyA23o48.decode("byUT205lSQ==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptorkyA23o48.decode("QiVC2U0ATv1pPQ==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptorkyA23o48.decode("QFA9wHR1XQ==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptorkyA23o48.decode("RVEp2g==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptorkyA23o48.decode("QCUtxHV1Ibc=")/*"aGVsbG93"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorkyA23o48 {
    static String algo = "ARCFOUR";
    static String kp = "91ZhkVMLzO53JmuK";

    public static String decode(String s) {
        String str;
        String key = "IfdZYlkm6hEUmtl5E6RvzQ==";
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