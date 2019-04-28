package com.example.wing_it;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.wing_it.Fragment.MapFragment;
import com.example.wing_it.Fragment.OnFragmentInteractionListener;
import com.example.wing_it.data.SaveDataSharedPref;
import com.example.wing_it.model.Restaurant;
import com.example.wing_it.model.RestaurantList;
import com.example.wing_it.model.RestaurantModel;
import com.example.wing_it.network.RestaurantService;
import com.example.wing_it.network.RestaurantSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    public static final String TAG = "FINDME";
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private SharedPreferences sharedPreferences;
    private double lat;
    private double lon;

    private List<RestaurantList> restaurantList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        sharedPreferences = getSharedPreferences(SaveDataSharedPref.SHARED_PREF_KEY, MODE_PRIVATE);
        if (sharedPreferences != null) {
            lat = Double.parseDouble(sharedPreferences.getString(SaveDataSharedPref.LAT_KEY, "0"));
            lon = Double.parseDouble(sharedPreferences.getString(SaveDataSharedPref.LON_KEY, "0"));
        }

//        SharedPreferences sharedPreferences = getSharedPreferences()

        drawerToggle = new ActionBarDrawerToggle(this, drawerlayout,R.string.open,R.string.close);

        drawerlayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home has been clicked", Toast.LENGTH_SHORT).show();
                        break;

                        case R.id.ashley:
                            Toast.makeText(MainActivity.this, "enrique", Toast.LENGTH_SHORT).show();
                            break;

                    case R.id.ben:
                        Toast.makeText(MainActivity.this, "greg", Toast.LENGTH_SHORT). show();
                        break;

                    case R.id.greg:
                        Toast.makeText(MainActivity.this, "ben", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.enrique:
                        break;
                }
                return true;
            }
        });
//
//        navigationView = findViewById(R.id.navigation_drawer);
//        headerView = navigationView.getHeaderView(0);
//        textView = findViewById(R.id.wing_it_title_nav);




        RestaurantSingleton.getInstance()
                .create(RestaurantService.class)
                .getRestaurants(lat, lon, 2000,100)
                .enqueue(new Callback<RestaurantModel>() {
                    @Override
                    public void onResponse(Call<RestaurantModel> call, Response<RestaurantModel> response) {
                        Log.d(TAG, "onResponse: " + response.body().getRestaurants().size());
                        restaurantList=response.body().getRestaurants();
                        moveToMapFragment(restaurantList);
                        Log.d(TAG, "onResponse: "+response.body().getResults_shown());
                    }
                    @Override
                    public void onFailure(Call<RestaurantModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());
                    }
                });
    }

    private void findViews() {
        navigationView = findViewById(R.id.navigation_drawer);
        drawerlayout = findViewById(R.id.drawer_main);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override

    public void moveToMapFragment(List<RestaurantList> restaurantList) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MapFragment.newInstance(restaurantList))
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void moveToEnriqueFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, EnriqueFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void moveToBenFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, BenFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void moveToGregFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, GregFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void moveToAshleyFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, AshleyFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void moveToDetailedFragment(RestaurantList restaurantList) {

    }

}

