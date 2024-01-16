package com.example.design

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.design.databinding.DesignSlideNumber21Binding


class Slide21MainActivity : AppCompatActivity() {
    private lateinit var binding: DesignSlideNumber21Binding
    private var currentColorPosition = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignSlideNumber21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        previousNextColorButtons()
    }


    private fun previousNextColorButtons() {

        /* Кнопка предыдущий цвет из массива. */
        binding.btPreviousColor.setOnClickListener {
            binding.myCustomView.firstStartColorIsNotSelected = false

            when (currentColorPosition) {

                /* Это проверка нужна, чтобы кнопка предыдущая позиция работала когда при
                 * пролистывании цветов в обратном направлении выбор доходит до 0 позиции т.е. до
                 * красного цвета, чтобы следующий индекс/позиция цвета был 0, а не -1.
                 */
                0 -> {
                    currentColorPosition = 9
                    colorToShowInCenter(currentColorPosition)
                    binding.myCustomView.colorClicked = currentColorPosition
                    binding.myCustomView.invalidate()

                }

                /* Это проверка нужна, чтобы кнопка предыдущая позиция работала при первом
                 * открытии приложения.
                 */
                -1 -> {
                    currentColorPosition = 9
                    colorToShowInCenter(currentColorPosition)
                    binding.myCustomView.colorClicked = currentColorPosition
                    binding.myCustomView.invalidate()

                }

                /* Иначе, если это не выбор при первом открытии и не "доход до 0 позиции красного
                 * цвета" просто уменьшаем счётчик.
                 */
                else -> {
                    currentColorPosition--
                    colorToShowInCenter(currentColorPosition)
                    binding.myCustomView.colorClicked = currentColorPosition
                    binding.myCustomView.invalidate()
                }
            }
        }

        /* Кнопка следующий цвет из массива. */
        binding.btNextColor.setOnClickListener {
            binding.myCustomView.firstStartColorIsNotSelected = false

            if (currentColorPosition == 9) {
                currentColorPosition = 0
                colorToShowInCenter(currentColorPosition)
                binding.myCustomView.colorClicked = currentColorPosition
                binding.myCustomView.invalidate()

            /* А здесь не нужна проверка на -1 как в кнопке предыдущий цвет т.к. изначально счётчик
             * равен -1 и мы при первом открытии просто увеличиваем его, а когда он доходит до
             * последнего цвета т.е. до 9, то просто сбрасываем на 0 позицию.
             */
            } else {
                currentColorPosition++
                colorToShowInCenter(currentColorPosition)
                binding.myCustomView.colorClicked = currentColorPosition
                binding.myCustomView.invalidate()
            }
        }
    }


    /** При нажатии на какой-либо цвет показываю его цветовой код в TextView.
     */
    private fun colorToShowInCenter(position: Int) {

        when (position) {
            0 -> { binding.tvColorIndex.text = Integer.toHexString(Color.RED) }
            1 -> { binding.tvColorIndex.text = Integer.toHexString(Color.BLUE) }
            2 -> { binding.tvColorIndex.text = Integer.toHexString(Color.GREEN) }
            3 -> { binding.tvColorIndex.text = Integer.toHexString(Color.CYAN) }
            4 -> { binding.tvColorIndex.text = Integer.toHexString(Color.BLACK) }
            5 -> { binding.tvColorIndex.text = Integer.toHexString(Color.MAGENTA) }
            6 -> { binding.tvColorIndex.text = Integer.toHexString(Color.DKGRAY) }
            7 -> { binding.tvColorIndex.text = Integer.toHexString(Color.YELLOW) }
            8 -> { binding.tvColorIndex.text = Integer.toHexString(Color.GREEN) }
            9 -> { binding.tvColorIndex.text = Integer.toHexString(Color.LTGRAY) }
        }
    }



}