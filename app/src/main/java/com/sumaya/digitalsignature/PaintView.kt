package com.sumaya.digitalsignature

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.sumaya.digitalsignature.MainActivity.Companion.paintBurst
import com.sumaya.digitalsignature.MainActivity.Companion.path

class PaintView(context: Context, attrs: AttributeSet? = null): View(context, attrs){

    companion object{
        var pathList = ArrayList<Path>()
        var currentBrush = Color.BLACK
    }

    init {
        paintBurst.color = currentBrush
        paintBurst.style = Paint.Style.STROKE
        paintBurst.strokeWidth = 8.6f
    }

    // here we just register the user's move finger. we need to draw it in screen.
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y =event.y
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x,y)
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x,y)
                pathList.add(path)
            }
        }
        postInvalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        for(i in pathList.indices){
            paintBurst.color = currentBrush
            canvas.drawPath(pathList[i], paintBurst)
            invalidate()
        }
    }

}