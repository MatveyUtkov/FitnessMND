package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService

class NotificationRecieve:BroadcastReceiver() {
    private var context:Context?=null
    private var isChannelCreated=false
    private lateinit var channel:NotificationChannel
    private var Even_Channel_id="Even_Channel_id"
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        this.context=context
        val action = intent?.action
        when (action) {
            Intent.ACTION_POWER_CONNECTED -> {
                notifyUser()
            }
            Intent.ACTION_POWER_DISCONNECTED ->  {

            }
        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun notifyUser(){
        if(!isChannelCreated){
            createChannel()
        }
        val mBuilder= NotificationCompat.Builder(context!!,Even_Channel_id)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Don't forget exercises")
            .setContentText("You did'n do your excercises today")
        val notification=mBuilder.build()
        val notificationManagerCompat=NotificationManagerCompat.from(context!!)
        notificationManagerCompat.notify(1,notification)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(){
        channel= NotificationChannel(Even_Channel_id,"Event",NotificationManager.IMPORTANCE_DEFAULT)
        channel.description="A channel for events"
       val notificationManager=getSystemService(context!!,NotificationManager::class.java)
        notificationManager!!.createNotificationChannel(channel)
        isChannelCreated=true

    }
}