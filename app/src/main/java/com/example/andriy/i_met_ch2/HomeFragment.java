package com.example.andriy.i_met_ch2;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeMap;

public class HomeFragment extends Fragment {
    LineChart lineChart;
    View view;
    Spinner chooseDevice;
    Spinner chooseTime;
    String[] dataDevice = {"Вода", "Газ"};
    String[] dataTime = {"Тиждень", "Місяць", "Рік"};
    Date mDate;
    long oneDay = new Date(1, 1, 2).getTime() - new Date(1, 1, 1).getTime();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDate = new Date();
        mDate.setHours(0);
        mDate.setMinutes(0);
        mDate.setSeconds(0);
        ArrayList<Date> currentWeek = getDateFromWeek(mDate);
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd  HH::mm");
        Log.d("ok", ft.format(currentWeek.get(0)));
        view = inflater.inflate(R.layout.fragment_home, container, false);
        chooseDevice = (Spinner) view.findViewById(R.id.chooseDevice);
        chooseTime = (Spinner) view.findViewById(R.id.chooseTime);
        ArrayAdapter<String> adapterChooseTime = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, dataTime);
        ArrayAdapter<String> adapterChooseDevice = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, dataDevice);
        adapterChooseDevice.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterChooseTime.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        chooseDevice.setAdapter(adapterChooseDevice);
        chooseTime.setAdapter(adapterChooseTime);
        chooseTime.setPrompt("Виберіть час");
        chooseDevice.setPrompt("Виберіть пристрій");
        lineChart = (LineChart) view.findViewById(R.id.lineChart);
        ArrayList<Entry> lineEntries = new ArrayList<Entry>();
//        lineEntries.add(new Entry(currentWeek.get(0).getTime()-oneDay, 1));
        lineEntries.add(new Entry(currentWeek.get(0).getTime(), 180));
        lineEntries.add(new Entry(currentWeek.get(1).getTime(), 182));
        lineEntries.add(new Entry(currentWeek.get(2).getTime(), 185));
        lineEntries.add(new Entry(currentWeek.get(3).getTime(), 186));
        lineEntries.add(new Entry(currentWeek.get(4).getTime(), 186));
        lineEntries.add(new Entry(currentWeek.get(5).getTime(), 190));
        lineEntries.add(new Entry(currentWeek.get(6).getTime(), 200));
//        lineEntries.add(new Entry(currentWeek.get(6).getTime()+oneDay, 1));

//        DefaultAxisValueFormatter k =new DefaultAxisValueFormatter( );

        LineDataSet lineDataSet = new LineDataSet(lineEntries, "Oil Price");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setCircleColor(Color.YELLOW);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleHoleRadius(3);
        lineDataSet.setDrawHighlightIndicators(true);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setValueTextSize(12);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setCircleColor(getResources().getColor(R.color.waterChart));
        lineDataSet.setColor(getResources().getColor(R.color.waterChart));
        lineDataSet.setCircleColorHole(getResources().getColor(R.color.waterChart));
        lineDataSet.setFillColor(getResources().getColor(R.color.waterChart));
        lineDataSet.setHighLightColor(getResources().getColor(R.color.waterChart));
        lineDataSet.setDrawFilled(true);
        LineData lineData = new LineData(lineDataSet);
        lineChart.getDescription().setText("");
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        lineChart.animateY(800);
        lineChart.getXAxis().setLabelCount(lineDataSet.getEntryCount());
        lineChart.setData(lineData);
        lineChart.getAxisLeft().setDrawGridLines(true);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.setDrawBorders(false);
        lineData.setDrawValues(false);
        lineChart.getXAxis().setGranularity(oneDay);
        lineChart.getAxisRight().setGranularity(1);
        lineChart.getAxisRight().setGranularityEnabled(true);
        HourAxisValueFormatter xAxisFormatter = new HourAxisValueFormatter();
        XAxis xAxis = lineChart.getXAxis();
        lineChart.getAxisRight().setDrawLabels(false);
        lineChart.getXAxis().setDrawLabels(true);
        xAxis.setValueFormatter(xAxisFormatter);
        lineChart.getLegend().setEnabled(false);


        return view;

    }

    ArrayList<Date> getDateFromWeek(Date date) {
        ArrayList<Date> result = new ArrayList<>();
        Boolean flag = true;
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd ");
        SimpleDateFormat format = new SimpleDateFormat("E");
        Date start = new Date();
        start.setMonth(date.getMonth());
        start.setYear(date.getYear());
        while (flag) {
            if (format.format(date).equals("Пн")) {
                start.setDate(date.getDate());
                flag = false;
            } else {
                date.setDate(date.getDate() - 1);
            }
            Log.d("ok", ft.format(date));

        }
        for (int i = 0; i <= 6; i++) {
            result.add(new Date(start.getYear(), start.getMonth(), start.getDate()));
            Log.d("ok", String.valueOf(start.getDate()));
            start.setDate(start.getDate() + 1);
        }
        return result;
    }


}
