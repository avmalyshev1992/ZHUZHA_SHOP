package com.example.zhuzha_shop

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationHelper {
    fun createNotification(context: Context, food: Food) {

        val mIntent = Intent(context, MainActivity::class.java)

        val pendingIntent =
            PendingIntent.getActivity(context, 0, mIntent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(context!!, NotificationConstants.CHANNEL_ID).apply {
            setSmallIcon(R.drawable.baseline_watch_later_24)
            setContentTitle("Не забудьте посмотреть!")
            setContentText(food.title)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setContentIntent(pendingIntent)
            setAutoCancel(true)
        }

        val notificationManager = NotificationManagerCompat.from(context)


    }
}