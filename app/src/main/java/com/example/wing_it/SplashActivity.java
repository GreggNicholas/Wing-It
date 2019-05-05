package com.example.wing_it;


import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wing_it.Data.SaveDataSharedPref;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class SplashActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static final int PERMISSIONS_REQUEST_LOCATION = 99;
    private double longitude;
    private double latitude;
    private LocationManager lm;
    private Location lastLocation;
    private SharedPreferences sharedPreferences;
    private SaveDataSharedPref saveDataSharedPref;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences = getSharedPreferences(SaveDataSharedPref.SHARED_PREF_KEY, MODE_PRIVATE);
        saveDataSharedPref = new SaveDataSharedPref(sharedPreferences);
        countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };

        getSupportActionBar().hide();

//        RestaurantSingleton.getInstance()
//                .create(RestaurantService.class)
//                .getRestaurants()

        ImageView imageView = findViewById(R.id.splash_gif);
        Glide.with(this)
                .load(R.drawable.splash)
                .placeholder(R.drawable.splash)
                .into(imageView);

        getLocation();


    }

    public void getLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
        } else {
            countDownTimer.start();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSIONS_REQUEST_LOCATION:
                if ((grantResults.length > 0) && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
                // Permission was granted.
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    final FusedLocationProviderClient fpc = LocationServices.getFusedLocationProviderClient(this);
                    fpc.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null){
                                lastLocation = location;
                                longitude = lastLocation.getLongitude();
                                latitude = lastLocation.getLatitude();
                                saveDataSharedPref.saveUserLatLon(latitude, longitude);

//                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                startActivity(intent);
                                countDownTimer.start();

                            }
                            else {
                                Toast.makeText(SplashActivity.this, "No Location Shown", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
                    Toast.makeText(this, "You need to have access to use this app", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
