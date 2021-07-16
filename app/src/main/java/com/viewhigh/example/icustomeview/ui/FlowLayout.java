package com.viewhigh.example.icustomeview.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    public static final String TAG = "FlowLayout";

    private List<List<View>> allLines; //记录所有的行，一行一行的存储，用于layout
    private List<Integer> lineHeights;//记录每一行的行高，用于layout

    public FlowLayout(Context context) {
        super(context);
        initMeasureParams();
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initMeasureParams() {
        allLines = new ArrayList<>();
        lineHeights = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure");
        initMeasureParams();

        //度量孩子
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int selfWidth = MeasureSpec.getSize(widthMeasureSpec);//ViewGroup解析的宽度
        int selfHeight = MeasureSpec.getSize(heightMeasureSpec);//ViewGroup解析的高度


        List<View> lineViews = new ArrayList<>();//保存一行中所有的View
        int lineWidthUsed = 0;// 记录这行已经用了多宽的size
        int lineHeight = 0; //一行的行高

        int parentNeedWidth = 0;//measure过程中，子View要求的父ViewGroup的宽
        int parentNeedHeight = 0;


        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);

            LayoutParams childLP = childView.getLayoutParams();
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                    paddingLeft + paddingRight,
                    childLP.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                    paddingBottom + paddingTop,
                    childLP.height);

            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            //获取子View的宽高
            int childMeasuredWidth = childView.getMeasuredWidth();
            int childMeasuredHeight = childView.getMeasuredHeight();

            //如果需要换行
            if (childMeasuredWidth + lineWidthUsed > selfWidth) {

                allLines.add(lineViews);
                lineHeights.add(lineHeight);

                //一旦换行、我们就可以判断当前行需要的宽和高，所以此时要记录下来
                parentNeedHeight += lineHeight;
                parentNeedWidth = Math.max(parentNeedWidth, lineWidthUsed);

                lineViews = new ArrayList<>();
                lineWidthUsed = 0;
                lineHeight = 0;
            }

            lineViews.add(childView);
            //每行都会有自己的宽度和高度
            lineWidthUsed = lineWidthUsed + childMeasuredWidth;//
            lineHeight = Math.max(lineHeight, childMeasuredHeight);

            //处理最后一行
            if (i == childCount - 1) {
                allLines.add(lineViews);
                lineHeights.add(lineHeight);

                parentNeedHeight += lineHeight;
                parentNeedWidth = Math.max(parentNeedWidth, lineWidthUsed);
            }

        }

        //根据子View度量结果、来重新度量自己ViewGroup
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int realWidth = (widthMode == MeasureSpec.EXACTLY) ? selfWidth : parentNeedWidth;
        int realHeight = (heightMode == MeasureSpec.EXACTLY) ? selfHeight : parentNeedHeight;
        //确定自己大小
        setMeasuredDimension(realWidth, realHeight);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(TAG, "onLayout");
//        int count = getChildCount();
//        for (int i = 0; i < count; i++) {
//            View childView = getChildAt(i);
//
//            childView.layout();
//        }

        int curL = getPaddingLeft();
        int curT = getPaddingTop();

        int lineCount = allLines.size();

        for (int i = 0; i < lineCount; i++) {
            List<View> listView = allLines.get(i);
            for (int j = 0; j < listView.size(); j++) {
                View view = listView.get(j);

                int left = curL;
                int top = curT;
                int right = left + view.getMeasuredWidth();
                int bottom = top + view.getMeasuredHeight();

                view.layout(left, top, right, bottom);

                curL = right;

            }

            curL = getPaddingLeft();
            curT = curT = lineHeights.get(i);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw");
    }
}
