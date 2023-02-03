package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WorkoutAct: AppCompatActivity() {
    var titlepage: TextView? = null
    var subtitlepage:TextView? = null
    var intropage:TextView? = null
    var subintropage:TextView? = null
    var btnexercise:TextView? = null
    var fitonetitle:TextView? = null
    var fitonedesc:TextView? = null
    var fittwotitle:TextView? = null
    var fittwodesc:TextView? = null
    var fitthreetitle:TextView? = null
    var fitthreedesc: TextView? = null
    var fitfourtitle:TextView? = null
    var fitfourdesc:TextView? = null
    var divpage: View? = null
    var bgprogress:android.view.View? = null

    var bttone: Animation? = null
    var bttwo:Animation? = null
    var bttfour:Animation? = null
    var bttfive:Animation? = null
    var bttsix:Animation? = null
    var bttseven:Animation? = null
    var btteight:Animation? = null

    var fitone: LinearLayout? = null
    var fittwo:LinearLayout? = null
    var fitthree:LinearLayout? = null
    var fitfour:LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone)
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo)
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour)
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive)
        bttsix = AnimationUtils.loadAnimation(this, R.anim.bttsix)
        bttseven = AnimationUtils.loadAnimation(this, R.anim.bttseven)
        btteight = AnimationUtils.loadAnimation(this, R.anim.btteight)
        titlepage = findViewById<View>(R.id.titlepage) as TextView
        subtitlepage = findViewById<View>(R.id.subtitlepage) as TextView
        btnexercise = findViewById<View>(R.id.btnexercise) as TextView
        fitonetitle = findViewById<View>(R.id.fitonetitle) as TextView
        fitonedesc = findViewById<View>(R.id.fitonedesc) as TextView
        fittwotitle = findViewById<View>(R.id.fittwotitle) as TextView
        fittwodesc = findViewById<View>(R.id.fittwodesc) as TextView
        fitthreetitle = findViewById<View>(R.id.fitthreetitle) as TextView
        fitthreedesc = findViewById<View>(R.id.fitthreedesc) as TextView
        fitfourtitle = findViewById<View>(R.id.fitfourtitle) as TextView
        fitfourdesc = findViewById<View>(R.id.fitfourdesc) as TextView

        btnexercise!!.setOnClickListener(View.OnClickListener {
            val a = Intent(this@WorkoutAct, StartWorkAct::class.java)
            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(a)
        })
        fitone = findViewById<View>(R.id.fitone) as LinearLayout
        fittwo = findViewById<View>(R.id.fittwo) as LinearLayout
        fitthree = findViewById<View>(R.id.fitthree) as LinearLayout
        fitfour = findViewById<View>(R.id.fitfour) as LinearLayout
        divpage = findViewById(R.id.divpage) as View
        bgprogress = findViewById(R.id.bgprogress) as View
        titlepage!!.startAnimation(bttone)
        subtitlepage!!.startAnimation(bttone)
        divpage!!.startAnimation(bttone)
        fitone!!.startAnimation(bttwo)
        fittwo!!.startAnimation(bttfour)
        fitthree!!.startAnimation(bttfive)
        fitfour!!.startAnimation(bttsix)
        btnexercise!!.startAnimation(btteight)
        bgprogress!!.startAnimation(bttseven)
    }

}