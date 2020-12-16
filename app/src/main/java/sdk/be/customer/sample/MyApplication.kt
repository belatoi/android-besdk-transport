package sdk.be.customer.sample

import androidx.multidex.MultiDexApplication
import sdk.be.customer.beSDK
import sdk.be.customer.enums.Environment

/**
 * User: ntnhuy
 * Date: 24/Nov/2020
 * Time: 15:41
 */
class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        beSDK.initialize(this)
            .setEnvironment(Environment.DEVELOPMENT)
            .setSplashClass(MainActivity::class.java)
    }
}