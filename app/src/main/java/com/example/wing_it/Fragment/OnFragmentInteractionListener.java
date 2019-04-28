package com.example.wing_it.Fragment;

import com.example.wing_it.model.RestaurantList;

import java.util.List;

public interface OnFragmentInteractionListener {
    void moveToMapFragment(List<RestaurantList> restaurantList);


    void moveToDetailedFragment(RestaurantList restaurantList);

    void moveToEnriqueFragment () ;
    void moveToBenFragment ();
    void moveToGregFragment ();
    void moveToAshleyFragment ();

}
