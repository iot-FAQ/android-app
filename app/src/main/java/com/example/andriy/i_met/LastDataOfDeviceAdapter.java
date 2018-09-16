package com.example.andriy.i_met;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LastDataOfDeviceAdapter extends ArrayAdapter<Device> {
    public LastDataOfDeviceAdapter (Activity context, ArrayList<Device> devices) {
        super(context, 0, devices);

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") final View listView = LayoutInflater.from(getContext()).inflate(
                R.layout.item_data, parent, false);
        TextView lastDataOfDevice=(TextView) listView.findViewById(R.id.lastDataOfDeviceLabel);
        Device current=getItem(position);
        lastDataOfDevice.setText(String.valueOf(current.getData())+" м. кб.");
        ConstraintLayout layout=(ConstraintLayout)listView.findViewById(R.id.layoutForLastData);
        if(current.getTypeDevice().equals(TypeDevice.GAS)){
            layout.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.background_for_gas));
        }else {
            layout.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.background_for_water));
        }
        return listView;
    }
}
