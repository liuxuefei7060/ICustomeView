package com.viewhigh.example.icustomeview.hencoder.draw1;

import android.content.Context;
import android.graphics.Canvas;
import androidx.annotation.Nullable;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {


    private Paint paint = new Paint();

    private RectF rectF = new RectF(200, 200, 800, 800);

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeWidth(20);

        canvas.drawArc(rectF, -180, 120, true, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(rectF, -60, 60, true, paint);

        paint.setColor(Color.GRAY);
        canvas.drawArc(rectF, 0, 10, true, paint);

        paint.setColor(Color.GREEN);
        canvas.drawArc(rectF, 10, 50, true, paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 60, 120, true, paint);

    }
}
