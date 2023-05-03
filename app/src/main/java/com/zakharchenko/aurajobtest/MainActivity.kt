package com.zakharchenko.aurajobtest

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zakharchenko.aurajobtest.services.NotificationJobService
import com.zakharchenko.aurajobtest.services.NotificationJobService.Companion.FIFTEEN_MINUTES

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StartJob()
    }

    fun StartJob(){
        val jobId = 1
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val jobInfo = JobInfo.Builder(jobId, ComponentName(this, NotificationJobService::class.java))
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setPeriodic(FIFTEEN_MINUTES)
            .build()
        val result = jobScheduler.schedule(jobInfo)
        Log.e("NotificationJobService", "MainActivity: StartJob")
        if (result == JobScheduler.RESULT_SUCCESS) {
            Log.d("NotificationJobService", "Job scheduled successfully!")
        }else{
            Log.d("NotificationJobService", "Job scheduled NOT successfully!")
        }
    }
}