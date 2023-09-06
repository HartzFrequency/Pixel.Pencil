package com.hartz.drawingapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private var drawingView : DrawingView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawing_view)
        val ib_brush:ImageButton = findViewById(R.id.image_button_brush)
        ib_brush.setOnClickListener{
            showBrushSizeChooser()
            }
    }
    private fun showBrushSizeChooser(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size")

        val smallButton: ImageButton = brushDialog.findViewById(R.id.image_button_small_brush)
        smallButton.setOnClickListener{
            drawingView?.setBrushSize(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumButton:ImageButton = brushDialog.findViewById(R.id.image_button_medium_brush)
        mediumButton.setOnClickListener{
            drawingView?.setBrushSize(20.toFloat())
            brushDialog.dismiss()
        }

        val largeButton:ImageButton = brushDialog.findViewById(R.id.image_button_large_brush)
        largeButton.setOnClickListener{
            drawingView?.setBrushSize(35.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }
}