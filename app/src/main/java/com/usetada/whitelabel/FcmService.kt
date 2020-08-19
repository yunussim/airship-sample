package com.usetada.whitelabel

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.urbanairship.push.fcm.AirshipFirebaseIntegration

class FcmService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        AirshipFirebaseIntegration.processMessageSync(applicationContext, message)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        AirshipFirebaseIntegration.processNewToken(applicationContext)
    }
}

