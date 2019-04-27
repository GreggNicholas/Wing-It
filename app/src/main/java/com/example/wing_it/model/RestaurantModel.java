package com.example.wing_it.model;

import java.util.List;

public class RestaurantModel {
    private String results_found;
    private String results_start;
    private String results_shown;
<<<<<<< HEAD
    private List<RestaurantList> restaurants;
=======

    private List<RestaurantList> restaurants;

>>>>>>> b3669ec2cf1577b84137c131024a858c52a60a00

    public String getResults_found() {
        return results_found;
    }

    public void setResults_found(String results_found) {
        this.results_found = results_found;
    }

    public String getResults_start() {
        return results_start;
    }

    public void setResults_start(String results_start) {
        this.results_start = results_start;
    }

    public String getResults_shown() {
        return results_shown;
    }

    public void setResults_shown(String results_shown) {
        this.results_shown = results_shown;
    }

    public List<RestaurantList> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantList> restaurants) {
        this.restaurants = restaurants;
    }
}
