package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class StartWorkAct:AppCompatActivity() {

    var intropage: TextView? = null
    var subintropage:TextView? = null
    var fitonetitle:TextView? = null
    var fitonedesc:TextView? = null
    var timerValue:TextView? = null
    var btnexercise:TextView? = null
    var divpage: View? = null
    var bgprogress:android.view.View? = null
    var fitone: LinearLayout? = null
    var imgTimer: ImageView? = null

    private val START_TIME_IN_MILLIS: Long = 50000
    private var countDownTimer: CountDownTimer? = null
    private var mTimerRunning = false
    private var mTimeLeftInMillis = START_TIME_IN_MILLIS

    var btthree: Animation? = null
    var bttfour:Animation? = null
    var ttbone:Animation? = null
    var ttbtwo:Animation? = null
    var alphago:Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_work)

        //Load Animations
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree)
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour)
        ttbone = AnimationUtils.loadAnimation(this, R.anim.ttbone)
        ttbtwo = AnimationUtils.loadAnimation(this, R.anim.ttbtwo)
        alphago = AnimationUtils.loadAnimation(this, R.anim.alphago)
        intropage = findViewById<View>(R.id.intropage) as TextView
        subintropage = findViewById<View>(R.id.subintropage) as TextView
        fitonetitle = findViewById<View>(R.id.fitonetitle) as TextView
        fitonedesc = findViewById<View>(R.id.fitonedesc) as TextView
        timerValue = findViewById<View>(R.id.timerValue) as TextView
        btnexercise = findViewById<View>(R.id.btnexercise) as TextView
        divpage = findViewById(R.id.divpage) as View
        bgprogress = findViewById(R.id.bgprogress) as View
        fitone = findViewById<View>(R.id.fitone) as LinearLayout
        imgTimer = findViewById<View>(R.id.imgtimer) as ImageView
        btnexercise!!.startAnimation(bttfour)
        bgprogress!!.startAnimation(btthree)
        fitone!!.startAnimation(ttbone)
        intropage!!.startAnimation(ttbtwo)
        subintropage!!.startAnimation(ttbtwo)
        divpage!!.startAnimation(ttbtwo)
        timerValue!!.startAnimation(alphago)
        imgTimer!!.startAnimation(alphago)
        startTimer()
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                Toast.makeText(applicationContext, "Done!", Toast.LENGTH_SHORT).show()
            }
        }.start()
        mTimerRunning = true
    }

    private fun updateCountDownText() {
        val minutes = (mTimeLeftInMillis / 1000).toInt() / 60
        val seconds = (mTimeLeftInMillis / 1000).toInt() % 60
        val timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        timerValue?.setText(timeLeft)
    }
}