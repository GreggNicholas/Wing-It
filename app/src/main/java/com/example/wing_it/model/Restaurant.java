package com.example.wing_it.model;

import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private String url;
    private Location location;
    private String average_cost_for_two;
    private String price_range;
    private String currency;
    private String thumb;
    private String menu_url;
    private String has_online_delivery;
    private String is_delivering_now;
    private String has_table_booking;
    private String deeplink;
    private String cuisines;
    private String all_reviews_count;
    private String photo_count;
    private String phone_numbers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(String average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getHas_online_delivery() {
        return has_online_delivery;
    }

    public void setHas_online_delivery(String has_online_delivery) {
        this.has_online_delivery = has_online_delivery;
    }

    public String getIs_delivering_now() {
        return is_delivering_now;
    }

    public void setIs_delivering_now(String is_delivering_now) {
        this.is_delivering_now = is_delivering_now;
    }

    public String getHas_table_booking() {
        return has_table_booking;
    }

    public void setHas_table_booking(String has_table_booking) {
        this.has_table_booking = has_table_booking;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getAll_reviews_count() {
        return all_reviews_count;
    }

    public void setAll_reviews_count(String all_reviews_count) {
        this.all_reviews_count = all_reviews_count;
    }

    public String getPhoto_count() {
        return photo_count;
    }

    public void setPhoto_count(String photo_count) {
        this.photo_count = photo_count;
    }

    public String getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(String phone_numbers) {
        this.phone_numbers = phone_numbers;
    }
}
