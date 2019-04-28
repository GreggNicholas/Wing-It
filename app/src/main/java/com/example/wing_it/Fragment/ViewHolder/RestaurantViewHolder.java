package com.example.wing_it.Fragment.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wing_it.Fragment.OnFragmentInteractionListener;
import com.example.wing_it.R;
import com.example.wing_it.Fragment.ViewHolderClick;
import com.example.wing_it.model.RestaurantList;

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

    public void OnBind(final RestaurantList restaurantList, final ViewHolderClick mapInterface) {
        nameTextview.setText(restaurantList.getRestaurant().getName());
        addresstextView.setText(String.format(" %s", restaurantList.getRestaurant().getLocation().getAddress()));

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(moreInfo.getContext(), "clicking", Toast.LENGTH_SHORT).show();
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
