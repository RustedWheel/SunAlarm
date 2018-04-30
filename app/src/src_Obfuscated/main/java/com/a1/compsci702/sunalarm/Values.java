package com.a1.compsci702.sunalarm;

import android.util.Base64;

public final class Values {

    public static String STORED_ALARMS = ds(new String[]{"Yw==", "bw==", "bQ==", "Lg==", "YQ==", "MQ==", "Lg==", "Yw==", "bw==", "bQ==", "cA==", "cw==", "Yw==", "aQ==", "Nw==", "MA==", "Mg==", "Lg==", "YQ==", "bA==", "YQ==", "cg==", "bQ==", "cw=="});

    public static String ALARM_ID = ds(new String[]{"Yw==", "bw==", "bQ==", "Lg==", "YQ==", "MQ==", "Lg==", "Yw==", "bw==", "bQ==", "cA==", "cw==", "Yw==", "aQ==", "Nw==", "MA==", "Mg==", "Lg==", "YQ==", "bA==", "YQ==", "cg==", "bQ==", "SQ==", "RA=="});

    public static String SUNRISE_TIME_CACHE = ds(new String[]{"Yw==", "bw==", "bQ==", "Lg==", "YQ==", "MQ==", "Lg==", "Yw==", "bw==", "bQ==", "cA==", "cw==", "Yw==", "aQ==", "Nw==", "MA==", "Mg==", "Lg==", "cw==", "dQ==", "bg==", "cg==", "aQ==", "cw==", "ZQ==", "dA==", "aQ==", "bQ==", "ZQ=="});

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
        String g = "NGhlYWQ";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = "cG9nZ2Vycw";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = "a2FwcGE";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = "d3Rm";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = "aGVsbG93";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}
