package com.example.wing_it.Interface;

import com.example.wing_it.Model.RestaurantList;

import java.util.List;

public interface OnFragmentInteractionListener {
    void moveToMapFragment(List<RestaurantList> restaurantList);


    void moveToDetailedFragment(RestaurantList restaurantList);

    void moveToEnriqueFragment () ;
    void moveToBenFragment ();
    void moveToGregFragment ();
    void moveToAshleyFragment ();

}
