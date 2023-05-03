package com.zakharchenko.aurajobtest.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by Konstantyn Zakharchenko on 03.05.2023.
 */
class BootReceiver : BroadcastReceiver() {
    val TAG: String = this.javaClass.name

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.e(TAG, "Action boot complete")

        }
    }
}