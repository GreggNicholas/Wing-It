package com.example.wing_it;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.wing_it.Fragment.MapFragment;
import com.example.wing_it.Fragment.OnFragmentInteractionListener;
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
    private List<RestaurantList> restaurantList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestaurantSingleton.getInstance()
                .create(RestaurantService.class)
                .getRestaurants("40.7590", "-73.9845")
                .enqueue(new Callback<RestaurantModel>() {
                    @Override
                    public void onResponse(Call<RestaurantModel> call, Response<RestaurantModel> response) {
                        restaurantList = response.body().getRestaurants();
                        Log.d(TAG, "onResponse: "+response.body().getResults_found());
                        Log.d(TAG, "onResponse: "+response.body().getRestaurants());

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, MapFragment.newInstance(restaurantList))
                                .addToBackStack(null)
                                .commit();

                    }

                    @Override
                    public void onFailure(Call<RestaurantModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());
                    }
                });

    }


    @Override
    public void moveToMapFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MapFragment.newInstance(restaurantList))
                .addToBackStack(null)
                .commit();
    }
}
