package com.example.wing_it.network;

import com.example.wing_it.model.RestaurantModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RestaurantService {
    @Headers("user-key: 33f05174531a71ca5c6cc372d63519b4")
    @GET("search")
    Call<RestaurantModel> getRestaurants(@Query("lat") String lat,
                                         @Query("lon") String lon);
}
