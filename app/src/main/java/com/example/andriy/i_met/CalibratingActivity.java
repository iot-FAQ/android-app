package com.example.andriy.i_met;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class CalibratingActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {
    int x_cord ;
    int y_cord ;
    RelativeLayout relativeLayout;
    String msg="ok";
    RelativeLayout.LayoutParams layoutParams;
    CardView pointOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calibrating);
        ImageView imageView = findViewById(R.id.calibrateImage);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        relativeLayout=findViewById(R.id.relativeLayout);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.test_calibrate_min, options));
        pointOne = findViewById(R.id.pointOne);
        pointOne.setOnTouchListener(this);
        pointOne.setOnDragListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
        }
        return true;
    }
    @Override
    public boolean onDrag(View v, DragEvent event) {
        View view;
        int action = event.getAction();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
//                v.setBackgroundDrawable(enterShape);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
//                v.setBackgroundDrawable(normalShape);
                break;
            case DragEvent.ACTION_DROP:
                // Dropped, reassign View to ViewGroup
                view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) v;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
//                v.setBackgroundDrawable(normalShape);
                // Regardless of valid or invalid drop show it again.
                // See https://developer.android.com/reference/android/view/DragEvent.html#ACTION_DRAG_ENDED
                view = (View) event.getLocalState();
                view.setVisibility(View.VISIBLE);
            default:
                break;
        }
        return true;
    }

}
