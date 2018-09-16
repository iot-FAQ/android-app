package com.example.andriy.i_met;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CardScrollAdapter extends ArrayAdapter<Device>{


    public CardScrollAdapter(Activity context, ArrayList<Device> devices) {
        super(context, 0, devices);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.item_device, parent, false);
        Device currentDevice=getItem(position);
        TextView nameDevice=(TextView) listItemView.findViewById(R.id.nameDeviceInItem);
        nameDevice.setText(currentDevice.getName());

        return listItemView;
    }


    }
