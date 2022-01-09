package com.example.gdsctocer


import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val CHANNEL_ID = "GDSCTCOERID"
const val CHANNEL_NAME = "GDSCTCOER"

class MyFirebaseMessagingService : FirebaseMessagingService()  {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        generateNotification(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)

    }

    @SuppressLint("RemoteViewLayout")
    fun getRemoteView(title: String,message: String) :  RemoteViews{
        val remoteView = RemoteViews("com.example.gdsctocer",R.layout.notifi)

        remoteView.setTextViewText(R.id.noti_title,title)
        remoteView.setTextViewText(R.id.message,message)
        remoteView.setImageViewResource(R.id.iv_notifi,R.drawable.ic_gdsc)

        return remoteView

    }


    fun generateNotification(title: String, message: String){

        val ni = Intent(this,MainActivity::class.java)
        ni.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this,0,ni,PendingIntent.FLAG_ONE_SHOT)

        var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_gdsc)
            .setAutoCancel(true)

            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title,message))




        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH)
           notificationManager.createNotificationChannel(notificationChannel)

        }
        notificationManager.notify(0,builder.build())

    }





}