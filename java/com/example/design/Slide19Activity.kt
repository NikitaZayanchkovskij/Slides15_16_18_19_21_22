package com.example.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.design.databinding.DesignSlideNumber19Binding


const val REFRESHMENT_TIME = 5000L


class Slide19Activity : AppCompatActivity() {
    private lateinit var binding: DesignSlideNumber19Binding
    private lateinit var timer: CountDownTimer

    private val yearWinnerArray = arrayOf("Art winner of 2010", "Art winner of 2011",
        "Art winner of 2012", "Art winner of 2013", "Art winner of 2014", "Art winner of 2015",
        "Art winner of 2016", "Art winner of 2017", "Art winner of 2018", "Art winner of 2019")

    private val nominationDescriptionArray = arrayOf("Japan art week", "Chinese art week",
        "Spanish art week", "Italian art week", "French art week", "Portuguese art week",
        "American art week", "British art week", "Danish art week", "German art week")

    private val profileImageArray = arrayOf(R.drawable.ic_user1, R.drawable.ic_user2, R.drawable.ic_user3,
        R.drawable.ic_user4, R.drawable.ic_user5, R.drawable.ic_user6, R.drawable.ic_user7,
        R.drawable.ic_user8, R.drawable.ic_user9, R.drawable.ic_user10)

    private val profileNameArray = arrayOf("User number 1", "User number 2", "User number 3",
        "User number 4", "User number 5", "User number 6", "User number 7", "User number 8",
        "User number 9", "User number 10")

    private val lastSeenArray = arrayOf("1 day ago", "2 days ago", "3 days ago", "4 days ago",
        "5 days ago", "6 days ago", "7 days ago", "8 days ago", "9 days ago", "10 days ago")

    private val howManyUsersRecommendedArray = arrayOf("10", "11", "12", "13", "14", "15", "16", "17", "18", "19")
    private val viewsArray = arrayOf("2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010")
    private val commentsArray = arrayOf("300", "301", "302", "303", "304", "305", "306", "307", "308", "309")
    private val likesArray = arrayOf("900", "901", "902", "903", "904", "905", "906", "907", "908", "909")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignSlideNumber19Binding.inflate(layoutInflater)
        setContentView(binding.root)

        startTimerForSlide19()
    }


    override fun onStop() {
        super.onStop()
        timer.cancel()
    }


    /** Запускаем отсчёт 5 секунд, чтобы обновлять профиль каждые 5 секунд.
     * По прошествии 5 секунд - функция запускает саму себя, чтобы повторить действие.
     * Так будет происходить пока пользователь не закроет приложение.
     */
    private fun startTimerForSlide19() {

        timer = object: CountDownTimer(REFRESHMENT_TIME, 100) {

            override fun onTick(timeLeft: Long) {}

            override fun onFinish() {
                setRandomUserInfoSlide19()
                startTimerForSlide19()
            }

        }.start()
    }


    /** Функция запускается каждый раз по прошествии 5 секунд, генерирует профиль пользователя со
     * случайными значениями и заполняет информацию на экран.
     */
    private fun setRandomUserInfoSlide19() = with(binding) {
        val randomYearWinner = yearWinnerArray[(0..9).random()]
        val randomNominationDescription = nominationDescriptionArray[(0..9).random()]
        val randomProfileImage = profileImageArray[(0..9).random()]
        val randomProfileName = profileNameArray[(0..9).random()]
        val randomLastSeen = lastSeenArray[(0..9).random()]
        val randomHowManyUsersRecommended = howManyUsersRecommendedArray[(0..9).random()]
        val randomViews = viewsArray[(0..9).random()]
        val randomComments = commentsArray[(0..9).random()]
        val randomLikes = likesArray[(0..9).random()]

        val user = Slide19DefaultUser(
            randomYearWinner, randomNominationDescription, randomProfileImage,
            randomProfileName, randomLastSeen, randomHowManyUsersRecommended, randomViews,
            randomComments, randomLikes
        )

        tvModelWinner.text = user.yearWinner
        tvTokyoArt.text = user.nominationDescription
        imIzabellaZhang.setImageResource(user.profileImage)
        tvIzabellaZhang.text = user.profileName
        tvDaysAgo.text = user.lastSeen
        val amountOfUsersRecommended = "${user.howManyUsersRecommended} / 56 users"
        tvUsers.text = amountOfUsersRecommended
        tvViews.text = user.views
        tvComments.text = user.comments
        tvLikes.text = user.likes
    }


}