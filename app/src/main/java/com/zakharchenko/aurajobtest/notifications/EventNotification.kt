package com.zakharchenko.aurajobtest.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.zakharchenko.aurajobtest.R

/**
 * Created by Konstantyn Zakharchenko on 03.05.2023.
 */
class EventNotification {
    companion object {
        const val NOTIFICATION_CHANNEL_ID = "Channel"
    }

    fun showNotification(context: Context) {
        var notificationManager = tryCreateNotificationChannel(context)

        val builder =
            NotificationCompat.Builder(context.applicationContext, NOTIFICATION_CHANNEL_ID)
                .setContentTitle("TestApplication").setContentText("Boots")
                .setSmallIcon(R.drawable.notification_icon)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify(0, builder.build())
    }

    private fun tryCreateNotificationChannel(context: Context): NotificationManager {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "TestNotificationName",
                importance
            ).apply {
                    description = "Description"
                    lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                }
            Log.e("NotificationJobService", "create chanel")

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            return notificationManager
        } else {
            return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
    }
}