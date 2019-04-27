package com.example.wing_it.data;

import android.content.SharedPreferences;

public class SaveDataSharedPref {
    public static final String LAT_KEY = "lat";
    public static final String LON_KEY = "lon";
    private SharedPreferences sharedPreferences;

    public SaveDataSharedPref(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveUserLatLon(double lat, double lon){
        sharedPreferences.edit()
                .putString(LAT_KEY, Double.toString(lat))
                .putString(LON_KEY, Double.toString(lon))
                .apply();
    }
}
