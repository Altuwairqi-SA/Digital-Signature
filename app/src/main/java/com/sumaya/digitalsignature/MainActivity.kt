package com.sumaya.digitalsignature

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sumaya.digitalsignature.PaintView.Companion.currentBrush
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBurst = Paint()
    }
    private lateinit var butChange: Button
    private lateinit var motionLayout: MotionLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motionLayout = findViewById(R.id.motionBackground)
        butChange = findViewById(R.id.changeColor)

        butChange.setOnClickListener {
            if (paintBurst.color == Color.BLACK) {
                currentBrush = Color.WHITE
                motionLayout.transitionToEnd()
            } else{
                currentBrush = Color.BLACK
                motionLayout.transitionToStart()
            }
        }
    }
}