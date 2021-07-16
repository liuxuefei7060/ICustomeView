package com.viewhigh.example.icustomeview.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.viewhigh.example.icustomeview.R


class DrawBitmap : View {
    private val p: Paint = Paint()
    private lateinit var bitmap: Bitmap

    constructor(context: Context?) : super(context) {
        loadBitmap(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        loadBitmap(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        loadBitmap(context)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        loadBitmap(context)
    }

    init {

    }

    private fun loadBitmap(context: Context?) {
        if (context != null) {
            bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.heimao)
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.GRAY)
        p.color = Color.YELLOW
        p.style = Paint.Style.STROKE
        p.strokeWidth = 8f


        canvas?.drawBitmap(bitmap, 100f, 100f, p)

//        canvas?.drawCircle(300f, 300f, 200f, p)
//        canvas?.drawColor(Color.parseColor("#88880000"))
    }

}
