package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.math.MathContext

class SudokuBoardView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet)
{
    private var sqrtSize = 3
    private var size = 9

    private var cellSizePixels = 0f

    private var selectedRow = -1
    private var selectedCol = -1



    private fun fillCells(canvas: Canvas)
    { if (selectedRow == -1 || selectedCol == -1) return

        for (r in 0..size)
        {
            for (c in 0..size){}
        }
    }

    private fun drawLines(canvas: Canvas)
    {
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), FatLinePaint)
        for (i in 1 until size)
        { val paintToUse = when(i % sqrtSize){0 -> FatLinePaint else -> ThinLinePaint}
          canvas.drawLine(i * cellSizePixels, 0f, i * cellSizePixels, height.toFloat(), paintToUse)
            canvas.drawLine( 0f, i * cellSizePixels, width.toFloat(), i * cellSizePixels, paintToUse)

        }
    }

    private val selectCellPaint = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
        color = Color.parseColor("#4682B4")
    }

    private val conflictCellPaint = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
        color = Color.parseColor("#B0C4DE")
    }

    private val FatLinePaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.DKGRAY
        strokeWidth = 4f
    }

    private val ThinLinePaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.DKGRAY
        strokeWidth = 2f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val sizePixels = Math.min(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(sizePixels, sizePixels)
    }

    override fun onDraw(canvas: Canvas)
    {
        cellSizePixels = (width / size).toFloat()
        fillCells(canvas)
        drawLines(canvas)

    }
}