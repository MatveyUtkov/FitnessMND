package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage)
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone)
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo)
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree)
        lefttoright = AnimationUtils.loadAnimation(this, R.anim.lefttoright)


        titlepage = findViewById<View>(R.id.titlepage) as TextView
        subtitlepage = findViewById<View>(R.id.subtitlepage) as TextView
        btnexercise = findViewById<View>(R.id.btnexercise) as TextView
        imgpage = findViewById<View>(R.id.imgpage) as ImageView
        bgprogress = findViewById(R.id.bgprogress) as View
        bgprogresstop = findViewById(R.id.bgprogresstop) as View

        imgpage!!.startAnimation(animimgpage)
        titlepage!!.startAnimation(bttone)
        subtitlepage!!.startAnimation(bttone)

        btnexercise!!.startAnimation(btthree)
        bgprogress!!.startAnimation(bttwo)
        bgprogresstop!!.startAnimation(lefttoright)
    }
}