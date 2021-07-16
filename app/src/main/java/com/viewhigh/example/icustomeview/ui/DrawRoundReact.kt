package com.viewhigh.example.icustomeview.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class DrawRoundReact : View {
    private val p: Paint = Paint()


    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.GRAY)
        p.color = Color.YELLOW
//        p.style = Paint.Style.STROKE
        p.strokeWidth = 8f
        canvas?.drawRoundRect(30f, 30f, 340f, 300f, 50f, 50f, p)
//        canvas?.drawColor(Color.parseColor("#88880000"))
    }

}
