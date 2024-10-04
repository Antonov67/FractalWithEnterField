package com.example.fractal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class Animation extends View {

    int count = 10;
    float[] x = new float[count];
    float[] y = new float[count];
    float[] vx = new float[count];
    float[] vy = new float[count];

    public Animation(Context context) {
        super(context);
        for (int i = 0; i < count; i++) {
            x[i] = (float) (Math.random() * 500);
            y[i] = (float) (Math.random() * 500);
            vx[i] = (float) (Math.random() * 6 - 3);
            vy[i] = (float) (Math.random() * 6 - 3);
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < count; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
        for (int i = 0; i < count; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
        }
        invalidate();
    }
}
