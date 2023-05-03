package com.zakharchenko.aurajobtest.services

import android.app.job.JobParameters
import android.app.job.JobService
import com.zakharchenko.aurajobtest.notifications.EventNotification

/**
 * Created by Konstantyn Zakharchenko on 03.05.2023.
 */
class NotificationJobService : JobService() {
    companion object {
        const val FIFTEEN_MINUTES: Long = 15 * 60 * 1000
    }
    override fun onStartJob(params: JobParameters): Boolean {
        EventNotification().showNotification(this)
        return true
    }
    override fun onStopJob(params: JobParameters): Boolean {
        return true
    }
}