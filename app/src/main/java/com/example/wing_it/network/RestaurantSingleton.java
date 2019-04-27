package com.example.wing_it.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantSingleton {

    private static Retrofit instance;
    private RestaurantSingleton(){}

    public static Retrofit getInstance(){
        if (instance == null){

            instance = new Retrofit.Builder()
                    .baseUrl("https://developers.zomato.com/api/v2.1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
