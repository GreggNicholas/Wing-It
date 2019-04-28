package com.example.wing_it.Fragment;

import android.content.Context;
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

import com.example.wing_it.R;
import com.example.wing_it.model.RestaurantList;


public class DetailedFragment extends Fragment {
    private static final String NAME_KEY = "param1";
    private static final String PICTURE_KEY = "param2";
    private static final String ADDRESS_KEY = "param3";
    private static final String CONTACT_KEY = "param4";
    private static final String RATING_KEY = "param5";

    private String restaurantName;
    private String restaurantFront;
    private String contactInfo;
    private String restaurantAddress;
    private String ratingBarArgs;
    private String deliveryToggle;

    private TextView nameTextView;
    private ImageView deliveryImageview;
    private ImageView restaurantImageView;
    private TextView addresstextView;
    private TextView contactInfoTextView;

    private RestaurantList restaurantList;

    private OnFragmentInteractionListener listener;

    public DetailedFragment() {
    }


    public static DetailedFragment newInstance(String param1, String param2) {
        DetailedFragment fragment = new DetailedFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, param1);
        args.putString(PICTURE_KEY, param2);
//        args.putString(ADDRESS_KEY, param3);
//        args.putString(CONTACT_KEY, param4);
//        args.putString(RATING_KEY, params5);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            restaurantName = getArguments().getString(NAME_KEY);
            restaurantFront = getArguments().getString(PICTURE_KEY);
            restaurantAddress = getArguments().getString(ADDRESS_KEY);
            contactInfo = getArguments().getString(CONTACT_KEY);
            ratingBarArgs = getArguments().getString(RATING_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detailed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatRatingBar ratingBar;
//        ImageView backgroundImageView = view.findViewById(R.id.detailedfragment_background);
        ratingBar = view.findViewById(R.id.detailedfragment_ratingbar);
        addresstextView = view.findViewById(R.id.detailedfragment_restaurantaddress);
        contactInfoTextView = view.findViewById(R.id.detailedfragment_contactinfo);
        restaurantImageView = view.findViewById(R.id.detailedfragment_restaurantpicture);
        nameTextView = view.findViewById(R.id.detailedfragment_restaurantname);
        ratingBar.setRating(Integer.parseInt(ratingBarArgs));


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
