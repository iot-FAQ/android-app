package com.example.andriy.i_met;

import android.app.Fragment;

import android.os.Bundle;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class ProfileFragment extends Fragment{
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_profile,container,false);
        ImageView sadDog=(ImageView) view.findViewById(R.id.sadDog);
        sadDog.setColorFilter(ContextCompat.getColor(getActivity(), R.color.colorAccent));


        return view;

    }
}