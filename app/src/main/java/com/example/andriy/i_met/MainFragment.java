package com.example.andriy.i_met;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.sephiroth.android.library.widget.HListView;

public class MainFragment extends Fragment {
    private View view;
    private HListView horizontalListView;
    private ArrayAdapter<Device> arrayAdapter;
    private static ArrayList<Device> arrayDevice = new ArrayList<>();
    ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        arrayAdapter = new CardScrollAdapter(getActivity(), MainFragment.uploadDevice());
        horizontalListView = view.findViewById(R.id.scroll_device);
        horizontalListView.setAdapter(arrayAdapter);
        return view;
    }

    public static ArrayList<Device> uploadDevice() {
        arrayDevice.add(new Device("Срисйька 81", TypeDevice.GAS, 123456));
        arrayDevice.add(new Device("Стрийська 81", TypeDevice.WATER, 123457));
        arrayDevice.add(new Device("Стрийська 115", TypeDevice.WATER, 123458));
        arrayDevice.add(new Device("Гашека 30", TypeDevice.WATER, 123459));
        arrayDevice.add(new Device("Стрийська 107", TypeDevice.WATER, 123467));
        arrayDevice.add(new Device("Максимовича 6", TypeDevice.WATER, 1223468));
        arrayDevice.add(new Device("Максимовича 9", TypeDevice.WATER, 123469));
        return arrayDevice;
    }

}
