package com.usetada.whitelabel

import android.app.Application
import com.urbanairship.UAirship

class CustomApp : Application() {

    override fun onCreate() {
        super.onCreate()
        UAirship.shared().pushManager.userNotificationsEnabled = true
    }
}