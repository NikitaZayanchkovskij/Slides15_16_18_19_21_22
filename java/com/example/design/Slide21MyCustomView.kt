package com.example.design

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class Slide21MyCustomView(context: Context, attributeSet: AttributeSet): View(context, attributeSet) {
    private val paintCircle = Paint()
    private val startAngle = 0f

    private val colorsArray = listOf(Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.BLACK,
        Color.MAGENTA, Color.DKGRAY, Color.YELLOW, Color.GREEN, Color.LTGRAY)

    private val sweepAngle = 360f / colorsArray.size
    var colorClicked = 0
    var firstStartColorIsNotSelected = true


    init {
        paintCircle.style = Paint.Style.FILL
        paintCircle.color = Color.RED
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawCircleButtons(canvas)
    }


    private fun drawCircleButtons(canvas: Canvas) {
        val centerX = width / 2f
        val centerY = width / 2f
        val radius = width.coerceAtMost(height) / 2f /* Это нужно чтобы круг не вышел за пределы
                                                                холста/canvas-а. */

        for (i in colorsArray.indices) {

            paintCircle.color = colorsArray[i] /* Следующий кусок круга будет такого цвета, какой
                                                        цвет на следующей позиции в массиве. */

            canvas.drawArc(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius,
                startAngle + i * sweepAngle,
                sweepAngle,
                true,
                paintCircle
            )
        }

        /* Рисуем центральный круг.
         */
        if (firstStartColorIsNotSelected == true) {
            paintCircle.color = Color.WHITE
        } else {
            paintCircle.color = colorsArray[colorClicked]
        }

        canvas.drawCircle(
            centerX,
            centerY,
            radius / 2f,
            paintCircle
        )
    }


}