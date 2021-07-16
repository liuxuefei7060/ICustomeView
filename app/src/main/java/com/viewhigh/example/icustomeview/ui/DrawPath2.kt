package com.viewhigh.example.icustomeview.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


class DrawPath2 : View {
    private val p: Paint = Paint()
    private val path: Path = Path()

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

    init {

        path.moveTo(100f,100f)
        path.quadTo(10f, 300f, 600f, 300f)
//        path.addArc(200f, 200f, 400f,
//            400f, -225f, 225f);
//        path.arcTo(400f, 200f, 600f,
//            400f, -180f, 225f, false);
//        path.lineTo(400f, 542f);
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.GRAY)
        p.color = Color.YELLOW
        p.style = Paint.Style.STROKE
        p.strokeWidth = 8f
        canvas?.drawPath(path, p)
//        canvas?.drawCircle(300f, 300f, 200f, p)
//        canvas?.drawColor(Color.parseColor("#88880000"))
    }

}
