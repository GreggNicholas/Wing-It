package com.example.wing_it;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

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
    private NavigationView navigationView;
    View headerView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerToggle = new ActionBarDrawerToggle(this, drawerlayout,R.string.open,R.string.close);
        drawerlayout = findViewById(R.id.drawer);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigation_drawer);
        headerView = navigationView.getHeaderView(0);
        textView.findViewById(R.id.wing_it_title_nav);




        RestaurantSingleton.getInstance()
                .create(RestaurantService.class)
                .getRestaurants(40.7590, -73.9845, 2000,15)
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
