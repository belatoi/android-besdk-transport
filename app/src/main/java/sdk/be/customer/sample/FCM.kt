package sdk.be.customer.sample

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import sdk.be.customer.beSDK

/**
 * User: ntnhuy
 * Date: 08/Dec/2020
 * Time: 10:33
 */
class FCM: FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        Log.e("device_token", p0)
        super.onNewToken(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (!beSDK.handleNotification(this, remoteMessage)) {
            // handle notification in your app
        }
    }
}