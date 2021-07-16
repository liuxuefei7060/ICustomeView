package com.viewhigh.example.icustomeview.hencoder.draw1;

import android.content.Context;
import android.graphics.Canvas;

import androidx.annotation.Nullable;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint paint = new Paint();

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        paint.setColor(Color.GRAY);
        canvas.drawRect(300, 100, 800, 500,
                  paint);
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        canvas.drawArc(300, 100, 900, 500,
                -160, 40, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(300, 100, 800, 500,
                -100, 80, true, paint);


        canvas.drawArc(300, 100, 800, 500,
                20, 140, false, paint);
    }
}
