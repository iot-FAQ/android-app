package com.example.andriy.i_met;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class LastDataOfDeviceAdapter extends ArrayAdapter<Device> {
    public LastDataOfDeviceAdapter(Activity context, ArrayList<Device> devices) {
        super(context, 0, devices);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") final View listView = LayoutInflater.from(getContext()).inflate(
                R.layout.item_data, parent, false);
        Device current = getItem(position);
        LineChart lineChart = listView.findViewById(R.id.lineChartDeviceData);
        final ArrayList<Entry> listEntry = new ArrayList<>();
        Map<String,Integer> map=current.getMapData();
        int k=0;
        final ArrayList<String> arrayLabels = new ArrayList<>();
        ArrayList<Integer> array=new ArrayList<Integer>();
        for (String i : map.keySet()) {
            array.add(Integer.parseInt(i));
        }
        arrayLabels.add("29/11/2018");
        arrayLabels.add("30/11/2018");
        arrayLabels.add("1/12/2018");
        arrayLabels.add("2/12/2018");
        arrayLabels.add("3/12/2018");
        arrayLabels.add("4/12/2018");
        arrayLabels.add("5/12/2018");

        for (int i : array){
            listEntry.add(new Entry(k, map.get(String.valueOf(i))));
            k+=1;
        }
        LineDataSet dataSet = new LineDataSet(listEntry, "gas");
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setDrawValues(false);
        dataSet.setDrawFilled(true);
        dataSet.setFillAlpha(170);
        if (current.getTypeDevice() == TypeDevice.GAS) {
            dataSet.setFillColor(ContextCompat.getColor(getContext(), R.color.gasChart));
        } else {
            dataSet.setFillColor(ContextCompat.getColor(getContext(), R.color.waterChart));
        }

        LineData lineData = new LineData(dataSet);
        XAxis xAxis = lineChart.getXAxis();
        YAxis yAxis= lineChart.getAxisLeft();
        yAxis.setGridColor(ContextCompat.getColor(getContext(),R.color.white));
        YAxis rightAxis=lineChart.getAxisRight();
        rightAxis.setEnabled(false);
        yAxis.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
        xAxis.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelRotationAngle(45);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return arrayLabels.get((int) value);
            }
        });
        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.setData(lineData);
        lineChart.invalidate();
        return listView;
    }
}
