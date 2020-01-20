package com.appnucleus.barcodeandqrscanner;

/**
 * Created by jaymi on 13-10-2017.
 */

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;



public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusename(String usename) {
        prefs.edit().putString("usename", usename).commit();
        //prefsCommit();
    }

    public String getusename() {
        String usename = prefs.getString("usename","");
        return usename;
    }
}