package com.example.andriy.i_met;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class StatisticFragment extends android.app.Fragment {
    private View view;
    private LineChart graphic;
    private static final String[] spinnerDevice={"Газ", "Вода"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_statistic, container, false);
        Spinner chooseDevice=(Spinner) view.findViewById(R.id.chooseDevice);
        chooseDevice.setAdapter(new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item, spinnerDevice));
        graphic=(LineChart) view.findViewById(R.id.graphic);
        setData();
        return view;

    }

    private ArrayList setYAxisValues(){
        ArrayList yVals = new ArrayList<>();
        yVals.add(new Entry(48, 1));
        yVals.add(new Entry(70.5f, 2));
        yVals.add(new Entry(100, 3));


        return yVals;
    }
    private ArrayList setXAxisValues(){
        ArrayList xVals = new ArrayList<>();
        xVals.add(10);
        xVals.add(20);
        xVals.add(30);
        xVals.add(40);
        xVals.add(50);
        return xVals;
    }
    private void setData() {
        ArrayList xVals = setXAxisValues();

        ArrayList<Entry> yVals = setYAxisValues();

        LineDataSet set1;

// create a dataset and give it a type
        set1 = new LineDataSet(yVals, "DataSet 1");
        set1.setFillAlpha(110);

        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);

        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

//LineData data = new LineData(xVals, dataSets);
        LineDataSet set = new LineDataSet(null, null);
        LineData data = new LineData();
        data.addDataSet(set1);
        data.setHighlightEnabled(false);

        graphic.setData(data);
    }
}
