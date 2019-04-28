package com.example.wing_it.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wing_it.Controller.RestaurantAdapter;
import com.example.wing_it.R;
import com.example.wing_it.model.RestaurantList;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MapFragment extends Fragment implements OnMapReadyCallback, ViewHolderClick {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private GoogleMap mGoogleMap;
    private MapView mapView;
    private RecyclerView recyclerView;
    private RestaurantAdapter restaurantAdapter;

    // TODO: Rename and change types of parameters
    private List<RestaurantList> mParam1=new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance(List<RestaurantList> param1) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, (Serializable) param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (List<RestaurantList>) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.map_recyclerView);
        restaurantAdapter = new RestaurantAdapter(mParam1, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(restaurantAdapter);

        mapView=view.findViewById(R.id.mapView);
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        mGoogleMap=googleMap;


        UiSettings uiSettings = mGoogleMap.getUiSettings();
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);


        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        for (RestaurantList res:mParam1) {

            googleMap.addMarker(new MarkerOptions().position(new LatLng(Float.valueOf(res.getRestaurant().getLocation().getLatitude()),Float.valueOf(res.getRestaurant().getLocation().getLongitude()))).title(res.getRestaurant().getName()).snippet(" "+res.getRestaurant().getCuisines()).icon(BitmapDescriptorFactory.fromResource(R.drawable.wings)));
            CameraPosition cityLocation=CameraPosition.builder().target(new LatLng(Double.valueOf(res.getRestaurant().getLocation().getLatitude()),Double.valueOf(res.getRestaurant().getLocation().getLongitude()))).zoom(13).bearing(0).tilt(45).build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cityLocation));
//            recyclerView.scrollToPosition(mParam1.indexOf(res));

        }
        final Marker marker_1 = null;

        mGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // TODO Auto-generated method stub
//                if(marker.equals(marker_1)){
                Log.d("Click", "test");
                for (RestaurantList res:mParam1) {
                    if (marker.getTitle().equals(res.getRestaurant().getName())){
                        recyclerView.scrollToPosition(mParam1.indexOf(res));
                    }
                }
                return false;
            }
        });



    }


    @Override
    public void onItemClicked(String lat, String lon) {
        CameraPosition cityLocation=CameraPosition.builder().target(new LatLng(Double.valueOf(lat),Double.valueOf(lon))).zoom(15).bearing(0).tilt(45).build();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cityLocation));

    }
}
