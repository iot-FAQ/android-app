package com.example.andriy.i_met_ch2;


import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Yasir on 02/06/16.
 */
public class HourAxisValueFormatter implements IAxisValueFormatter
{

    private DateFormat mDataFormat;
    private Date mDate;

    public HourAxisValueFormatter() {
        this.mDataFormat = new SimpleDateFormat("dd.MM", Locale.ENGLISH);
        this.mDate = new Date();
    }


    /**
     * Called when a value from an axis is to be formatted
     * before being drawn. For performance reasons, avoid excessive calculations
     * and memory allocations inside this method.
     *
     * @param value the value to be formatted
     * @param axis  the axis the value belongs to
     * @return
     */
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        // convertedTimestamp = originalTimestamp - referenceTimestamp
        long convertedTimestamp = (long) value;

        // Convert timestamp to hour:minute
        return getHour((long)value);
    }


    public int getDecimalDigits() {
        return 0;
    }

    private String getHour(long timestamp){
        try{
            mDate.setTime(timestamp);
            return mDataFormat.format(mDate);
        }
        catch(Exception ex){
            return "xx";
        }
    }
}