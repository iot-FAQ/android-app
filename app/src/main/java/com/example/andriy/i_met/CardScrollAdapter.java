package com.example.andriy.i_met;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CardScrollAdapter extends ArrayAdapter<Device>{


    CardScrollAdapter(Activity context, ArrayList<Device> devices) {
        super(context, 0, devices);

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        @SuppressLint("ViewHolder") final View listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.item_device, parent, false);
        Device currentDevice=getItem(position);
        TextView nameDevice= listItemView.findViewById(R.id.nameDeviceInItem);
        TextView serialNumber=listItemView.findViewById(R.id.serialNumberDeviceOnItem);
        serialNumber.setVisibility(View.INVISIBLE);
        if (currentDevice != null) {
            serialNumber.setText(String.valueOf(currentDevice.getSerialNumber()));
            nameDevice.setText(currentDevice.getAddress());
        }
        return listItemView;
    }


    }
