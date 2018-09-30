package com.example.andriy.i_met;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawMakerCalibrating extends View {
    Paint p;
    Rect rect;
    public DrawMakerCalibrating(Context context) {
        super(context);

        p=new Paint();
        rect=new Rect();
    }
    @Override
    public void onDraw(Canvas canvas) {
        p.setColor(Color.YELLOW);
        canvas.drawCircle(950, 30, 25, p);
    }

}
