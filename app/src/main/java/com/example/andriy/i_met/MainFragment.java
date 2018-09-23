package com.example.andriy.i_met;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import it.sephiroth.android.library.widget.HListView;

public class MainFragment extends Fragment {
    private View view;
    private HListView horizontalListView;
    private ArrayAdapter<Device> arrayAdapter;
    ArrayList<Device> arrayDevice;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        arrayDevice = new ArrayList<>();
        arrayDevice.add(new Device("hello",TypeDevice.GAS));
        arrayDevice.add(new Device("hello",TypeDevice.WATER));
        arrayDevice.add(new Device("hello",TypeDevice.WATER));
        arrayDevice.add(new Device("hello",TypeDevice.WATER));
        arrayDevice.add(new Device("hello",TypeDevice.WATER));
        arrayDevice.add(new Device("hello",TypeDevice.WATER));
        arrayDevice.add(new Device("hello",TypeDevice.WATER));
        arrayAdapter = new CardScrollAdapter(getActivity(), arrayDevice);
        horizontalListView = (HListView) view.findViewById(R.id.scroll_device);
        horizontalListView.setAdapter(arrayAdapter);
        return view;
    }
}
