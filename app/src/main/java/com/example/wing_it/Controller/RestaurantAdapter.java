package com.example.wing_it.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wing_it.Fragment.OnFragmentInteractionListener;
import com.example.wing_it.Fragment.ViewHolder.RestaurantViewHolder;
import com.example.wing_it.Fragment.ViewHolderClick;
import com.example.wing_it.R;
import com.example.wing_it.model.RestaurantList;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {
    private List<RestaurantList> restaurantLists;
    private ViewHolderClick mapInterface;
    private OnFragmentInteractionListener listener;


    public RestaurantAdapter(List<RestaurantList> restaurantLists, ViewHolderClick mapInterface, OnFragmentInteractionListener listener) {
        this.restaurantLists = restaurantLists;
        this.mapInterface = mapInterface;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childViewHolder = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new RestaurantViewHolder(childViewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
        restaurantViewHolder.OnBind(restaurantLists.get(i), mapInterface, listener);

    }

    @Override
    public int getItemCount() {
        return restaurantLists.size();
    }
}
