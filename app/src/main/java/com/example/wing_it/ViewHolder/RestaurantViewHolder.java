package com.example.wing_it.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wing_it.Interface.OnFragmentInteractionListener;
import com.example.wing_it.R;
import com.example.wing_it.Interface.ViewHolderClick;
import com.example.wing_it.Model.RestaurantList;

public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextview;
        private TextView addresstextView;
        private Button moreInfo;
        private OnFragmentInteractionListener onFragmentInteractionListener;

    public RestaurantViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextview=itemView.findViewById(R.id.name_text_view);
        moreInfo = itemView.findViewById(R.id.moreinfo);
        addresstextView=itemView.findViewById(R.id.address_text_view);

    }

    public void OnBind(final RestaurantList restaurantList, final ViewHolderClick mapInterface, final OnFragmentInteractionListener onFragmentInteractionListener) {
        nameTextview.setText(restaurantList.getRestaurant().getName());
        addresstextView.setText(String.format(" %s", restaurantList.getRestaurant().getLocation().getAddress()));


        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onFragmentInteractionListener.moveToDetailedFragment(restaurantList);

            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mapInterface.onItemClicked(restaurantList.getRestaurant().getLocation().getLatitude(),
                        restaurantList.getRestaurant().getLocation().getLongitude());


            }
        });
    }
}
