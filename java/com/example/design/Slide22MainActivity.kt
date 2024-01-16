package com.example.design


import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design.databinding.DesignSlideNumber22Binding


class Slide22MainActivity : AppCompatActivity() {
    private lateinit var binding: DesignSlideNumber22Binding
    private var barProgress = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignSlideNumber22Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setRandomProgressBarValueSlide22()
    }


    /** Функция, при нажатии на кнопку на экране, генерирует значение прогресс бара от 0 до 100,
     * отображает соответствующий label в середине прогресс бара (например 10%) и анимирует
     * переход к этому значению на прогресс баре.
     */
    private fun setRandomProgressBarValueSlide22() {

        binding.btSetRandomProgressValue.setOnClickListener {

            val randomNumber = (0..100).random()
            barProgress = randomNumber
            val progressLabel = "$barProgress%"

            val progressAnimator = ValueAnimator.ofInt(0, randomNumber)
            progressAnimator.duration = 500L

            progressAnimator.addUpdateListener {
                binding.progressBar.progress = progressAnimator.animatedValue as Int
                binding.tvProgress.text = progressLabel
            }

            progressAnimator.start()
        }
    }


}