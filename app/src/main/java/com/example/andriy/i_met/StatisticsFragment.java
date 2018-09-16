package com.example.andriy.i_met;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import it.sephiroth.android.library.widget.HListView;

public class StatisticsFragment extends Fragment{
    private HListView horizontalLIstOfLastData;
    private View view;
    private ArrayList arrayDevice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_statistics,container,false);
        horizontalLIstOfLastData=(HListView) view.findViewById(R.id.lastDataOfDevice);
        arrayDevice=new ArrayList();
        arrayDevice.add(new Device("hello",TypeDevice.GAS,56));
        arrayDevice.add(new Device("hello",TypeDevice.WATER,67));
        arrayDevice.add(new Device("hello",TypeDevice.GAS,32));
        arrayDevice.add(new Device("hello",TypeDevice.WATER,90));
        arrayDevice.add(new Device("hello",TypeDevice.GAS,6574));
        arrayDevice.add(new Device("hello",TypeDevice.WATER,435));
        arrayDevice.add(new Device("hello",TypeDevice.WATER,34534));
        ArrayAdapter arrayAdapter=new LastDataOfDeviceAdapter(getActivity(),arrayDevice);
        horizontalLIstOfLastData.setAdapter(arrayAdapter);
        return view;
    }

}
