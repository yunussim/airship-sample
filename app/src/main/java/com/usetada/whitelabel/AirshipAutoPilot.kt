package com.usetada.whitelabel

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import com.urbanairship.AirshipConfigOptions
import com.urbanairship.Autopilot
import com.urbanairship.UAirship

class AirshipAutoPilot : Autopilot() {


    companion object {
        const val CHANNEL = "customChannel"
        const val fcmSenderId = "xxxxxxxx"
    }

    override fun onAirshipReady(airship: UAirship) {
        super.onAirshipReady(airship)

        airship.pushManager.userNotificationsEnabled = true

        // Android O
        if (Build.VERSION.SDK_INT >= 26) {
            val context = UAirship.getApplicationContext()
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val channel = NotificationChannel(
                CHANNEL,
                context.getString(R.string.app_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )

            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun createAirshipConfigOptions(context: Context): AirshipConfigOptions? {
        return AirshipConfigOptions.Builder()
            .setProductionAppKey("-airship-production-key-")
            .setProductionAppSecret("-airship-production-secret-")
            .setInProduction(true)
            .setFcmSenderId(fcmSenderId)
            .setNotificationIcon(R.mipmap.ic_launcher) // change to your icon
            .setNotificationAccentColor(Color.parseColor("#ff0000")) // change to your accent color
            .setNotificationChannel(CHANNEL)
            .build()
    }

}