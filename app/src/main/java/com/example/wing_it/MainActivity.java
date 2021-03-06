package com.example.wing_it;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.wing_it.Fragment.DetailedFragment;
import com.example.wing_it.Fragment.MapFragment;
import com.example.wing_it.Interface.OnFragmentInteractionListener;
import com.example.wing_it.Data.SaveDataSharedPref;
import com.example.wing_it.Model.RestaurantList;
import com.example.wing_it.Model.RestaurantModel;
import com.example.wing_it.Network.RestaurantService;
import com.example.wing_it.Network.RestaurantSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    public static final String TAG = "FINDME";
    private SharedPreferences sharedPreferences;

    private double lat;
    private double lon;

    private List<RestaurantList> restaurantList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        sharedPreferences = getSharedPreferences(SaveDataSharedPref.SHARED_PREF_KEY, MODE_PRIVATE);
        if (sharedPreferences != null) {
            lat = Double.parseDouble(sharedPreferences.getString(SaveDataSharedPref.LAT_KEY, "0"));
            lon = Double.parseDouble(sharedPreferences.getString(SaveDataSharedPref.LON_KEY, "0"));
        }

//        SharedPreferences sharedPreferences = getSharedPreferences()






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




    @Override

    public void moveToMapFragment(List<RestaurantList> restaurantList) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MapFragment.newInstance(restaurantList))
                .addToBackStack(null)
                .commit();


    }




    @Override
    public void moveToDetailedFragment(RestaurantList restaurantList) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailedFragment.newInstance(restaurantList))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void moveToEnriqueFragment() {

    }

    @Override
    public void moveToBenFragment() {

    }

    @Override
    public void moveToGregFragment() {

    }

    @Override
    public void moveToAshleyFragment() {

    }

}

