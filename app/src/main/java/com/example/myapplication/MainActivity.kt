package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var mText: TextView? = null
    var mImageView: ImageView? = null
    var mButton: Button? = null
    var titlepage: TextView? = null
    var subtitlepage:TextView? = null
    var btnexercise:TextView? = null
    var imgpage: ImageView? = null
    var animimgpage: Animation? = null
    var bttone:Animation? = null
    var bttwo:Animation? = null
    var btthree:Animation? = null
    var lefttoright:Animation? = null
    var bgprogress: View? = null
    var bgprogresstop:android.view.View? = null
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mImageView=findViewById(R.id.bicep)
        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage)
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone)
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo)
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree)
        lefttoright = AnimationUtils.loadAnimation(this, R.anim.lefttoright)


        titlepage = findViewById<View>(R.id.titlepage) as TextView
        btnexercise = findViewById<View>(R.id.btnexercise) as TextView
        imgpage = findViewById<View>(R.id.img_1) as ImageView
        bgprogress = findViewById(R.id.bgprogress) as View
        bgprogresstop = findViewById(R.id.bgprogresstop) as View

        imgpage!!.startAnimation(animimgpage)
        titlepage!!.startAnimation(bttone)
        btnexercise!!.startAnimation(btthree)
        bgprogress!!.startAnimation(bttwo)
        bgprogresstop!!.startAnimation(lefttoright)
        btnexercise!!.setOnClickListener {
            val a = Intent(this, Workout_Categories::class.java)
            startActivity(a)
        }
        val notificationRecieve=NotificationRecieve()
        val filter=IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        this.registerReceiver(notificationRecieve, filter)
    }
}