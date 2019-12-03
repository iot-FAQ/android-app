package com.example.andriy.i_met;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

public class CalibratingActivity extends AppCompatActivity implements View.OnTouchListener {
    RelativeLayout relativeLayout;
    String msg = "ok";
    Context context;
    float dp;
    RelativeLayout.LayoutParams layoutParams;
    private CardView zoneCalibrating;
    private CardView firstPoint;
    private CardView secondPoint;
    private CardView thirdPoint;
    private CardView fourthPoint;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        dp = context.getResources().getDisplayMetrics().density;
        zoneCalibrating = findViewById(R.id.zoneCalibrating);
        setContentView(R.layout.activity_calibrating);
        ImageView imageView = findViewById(R.id.calibrateImage);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        relativeLayout = findViewById(R.id.relativeLayout);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.test_calibrate_min, options));

        firstPoint = findViewById(R.id.firstPoint);
        secondPoint = findViewById(R.id.secondPoint);
        thirdPoint = findViewById(R.id.thirdPoint);
        fourthPoint = findViewById(R.id.forthPoint);
        secondPoint.setOnTouchListener(this);
        thirdPoint.setOnTouchListener(this);
        fourthPoint.setOnTouchListener(this);
        firstPoint.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        zoneCalibrating=findViewById(R.id.zoneCalibrating);
        Log.d("ok", String.valueOf(motionEvent.getOrientation()));
        if (motionEvent.getAction() == 2) {
            switch (view.getId()) {
                case R.id.firstPoint:
                    zoneCalibrating.setX(motionEvent.getRawX()+(float)(7.5*dp));
                    zoneCalibrating.setY(motionEvent.getRawY()-(float)(172.5*dp));
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    secondPoint.setX(motionEvent.getRawX());
                    thirdPoint.setY(motionEvent.getRawY() - 180 * dp);
                    zoneCalibrating.setLayoutParams(new RelativeLayout.LayoutParams((int) (thirdPoint.getX()-firstPoint.getX()),(int) (secondPoint.getY()-firstPoint.getY())));
                    break;
                case R.id.secondPoint:
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    firstPoint.setX(motionEvent.getRawX());
                    zoneCalibrating.setX(firstPoint.getX()+(float)(7.5*dp));
                    zoneCalibrating.setY(firstPoint.getY()+(float)(7.5*dp));
                    fourthPoint.setY(motionEvent.getRawY() - 180 * dp);
                    zoneCalibrating.setLayoutParams(new RelativeLayout.LayoutParams((int) (thirdPoint.getX()-firstPoint.getX()),(int) (secondPoint.getY()-firstPoint.getY())));
                    break;
                case R.id.thirdPoint:

                    zoneCalibrating.setY(motionEvent.getRawY()-(float)(172.5*dp));
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    fourthPoint.setX(motionEvent.getRawX());
                    firstPoint.setY(motionEvent.getRawY() - 180 * dp);
                    zoneCalibrating.setX(firstPoint.getX()+(float)(7.5*dp));
                    zoneCalibrating.setY(firstPoint.getY()+(float)(7.5*dp));
                    zoneCalibrating.setLayoutParams(new RelativeLayout.LayoutParams((int) (thirdPoint.getX()-firstPoint.getX()),(int) (secondPoint.getY()-firstPoint.getY())));
                    break;
                case R.id.forthPoint:
                    zoneCalibrating.setX(firstPoint.getX()+(float)(7.5*dp));
                    zoneCalibrating.setY(firstPoint.getY()+(float)(7.5*dp));
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    thirdPoint.setX(motionEvent.getRawX());
                    secondPoint.setY(motionEvent.getRawY() - 180 * dp);
                    zoneCalibrating.setLayoutParams(new RelativeLayout.LayoutParams((int) (thirdPoint.getX()-firstPoint.getX()),(int) (secondPoint.getY()-firstPoint.getY())));
                    break;
            }
        }
        if (motionEvent.getAction() == 1) {
            switch (view.getId()) {
                case R.id.firstPoint:
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    secondPoint.setX(motionEvent.getRawX());
                    thirdPoint.setY(motionEvent.getRawY() - 180 * dp);
                    break;
                case R.id.secondPoint:
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    firstPoint.setX(motionEvent.getRawX());
                    fourthPoint.setY(motionEvent.getRawY() - 180 * dp);
                    break;
                case R.id.thirdPoint:
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    fourthPoint.setX(motionEvent.getRawX());
                    firstPoint.setY(motionEvent.getRawY() - 180 * dp);
                    break;
                case R.id.forthPoint:
                    view.setX(motionEvent.getRawX());
                    view.setY(motionEvent.getRawY() - 180 * dp);
                    thirdPoint.setX(motionEvent.getRawX());
                    secondPoint.setY(motionEvent.getRawY() - 180 * dp);
                    break;
            }
        }

        Log.d("params", String.valueOf(motionEvent.getAction()));

        return true;
    }

}
