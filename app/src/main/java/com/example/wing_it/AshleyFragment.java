package com.example.wing_it;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AshleyFragment extends Fragment {


    public AshleyFragment() {
        // Required empty public constructor
    }

    public static AshleyFragment newInstance () {
        return new AshleyFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ashley, container, false);
    }

}
