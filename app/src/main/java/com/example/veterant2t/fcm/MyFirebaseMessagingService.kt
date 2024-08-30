package com.example.veterant2t.fcm

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.util.Log
import com.example.veterant2t.ApiSetup.ApiClient
import com.example.veterant2t.ApiSetup.tokenRegistrationRequest
import com.example.veterant2t.ApiSetup.tokenRegistrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        // Handle FCM messages here.
        Log.d("FCM", "From: ${remoteMessage.from}")

        // Check if message contains a data payload.
        remoteMessage.data.isNotEmpty().let {
            Log.d("FCM", "Message data payload: ${remoteMessage.data}")
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("FCM", "Message Notification Body: ${it.body}")
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM", "Refreshed token: $token")
        // Implement this method to send the token to your app server.
        val tokenCall=ApiClient.authService.registerDeviceToken(tokenRegistrationRequest(token))

        tokenCall.enqueue(object: Callback<tokenRegistrationResponse> {
            override fun onResponse(call: Call<tokenRegistrationResponse>, response: Response<tokenRegistrationResponse>) {
                Log.d("FCM", "Token registered successfully")
            }

            override fun onFailure(call: Call<tokenRegistrationResponse>, t: Throwable) {
                Log.d("FCM", "Failed to register token")
                println(t.message)
            }

        })
    }
}


