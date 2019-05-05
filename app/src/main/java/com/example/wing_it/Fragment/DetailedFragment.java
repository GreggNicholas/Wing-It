package com.example.wing_it.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wing_it.Interface.OnFragmentInteractionListener;
import com.example.wing_it.R;
import com.example.wing_it.Model.RestaurantList;


final public class DetailedFragment extends Fragment {
    private static final String RESTAURANTS_KEY = "param1";
    private RestaurantList restaurantList;
    private OnFragmentInteractionListener listener;

    public DetailedFragment() {
    }

    public static DetailedFragment newInstance(RestaurantList restaurantList) {
        DetailedFragment fragment = new DetailedFragment();
        Bundle args = new Bundle();
        args.putSerializable(RESTAURANTS_KEY, restaurantList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            restaurantList = (RestaurantList) getArguments().getSerializable(RESTAURANTS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detailed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ImageView backgroundImageView = view.findViewById(R.id.detailedfragment_background);
        final AppCompatRatingBar ratingBar = view.findViewById(R.id.detailedfragment_ratingbar);
        ratingBar.setRating(3);
        final TextView addresstextView = view.findViewById(R.id.detailedfragment_restaurantaddress);
        final TextView contactInfoTextView = view.findViewById(R.id.detailedfragment_contactinfo);
        final ImageView restaurantImageView = view.findViewById(R.id.detailedfragment_restaurantpicture);
        final TextView nameTextView = view.findViewById(R.id.detailedfragment_restaurantname);
        addresstextView.setText(restaurantList.getRestaurant().getLocation().getAddress());
        contactInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getResources().getString(R.string.phone_number), null));
                startActivity(intent);
            }
        });
//        Picasso.get().load().resize(1000, 400).into(restaurantImageView);
        nameTextView.setText(restaurantList.getRestaurant().getName());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
