package com.example.wing_it.Data;

import android.content.SharedPreferences;

public class SaveDataSharedPref {
    public static final String SHARED_PREF_KEY = "SHARED PREF KEY";
    public static final String LAT_KEY = "lat";
    public static final String LON_KEY = "lon";
    public static final String NAME = "NAME";
    public static final String PIC = "PIC";
    public static final String PHONE = "PHONE";
    public static final String ADDRESS = "ADDRESS";
    public static final String RATING = "RATING";
    public static final String ISDELIVERY = "ISDELIVERY";
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

    public void saveRestaurantInfo(String name, String pic, String phone, String address, String rating, boolean isDeliveryAvailable){
        sharedPreferences.edit()
                .putString(NAME, name)
                .putString(PIC, pic)
                .putString(PHONE, phone)
                .putString(ADDRESS, address)
                .putString(RATING, rating)
                .putBoolean(ISDELIVERY, isDeliveryAvailable)
                .apply();
    }
}
