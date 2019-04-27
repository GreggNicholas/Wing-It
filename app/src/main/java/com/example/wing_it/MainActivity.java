package com.example.wing_it;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.wing_it.model.Restaurant;
import com.example.wing_it.model.RestaurantModel;
import com.example.wing_it.network.RestaurantService;
import com.example.wing_it.network.RestaurantSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "FINDME";
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerlayout = findViewById(R.id.drawer);

        RestaurantSingleton.getInstance()
                .create(RestaurantService.class)
                .getRestaurants(40.7590, 73.9845, 2000,15)
                .enqueue(new Callback<RestaurantModel>() {
                    @Override
                    public void onResponse(Call<RestaurantModel> call, Response<RestaurantModel> response) {
                        Log.d(TAG, "onResponse: "+response.body().getResults_shown());
                    }
                    @Override
                    public void onFailure(Call<RestaurantModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());
                    }
                });
    }
}
