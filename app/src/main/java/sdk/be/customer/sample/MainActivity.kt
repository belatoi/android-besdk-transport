package sdk.be.customer.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import sdk.be.customer.Startbe
import sdk.be.customer.beSDK
import sdk.be.customer.enums.Language

fun <R> String?.isTextNotEmpty(block: (String) -> R): R? {
    return if (this == null || this.trim().isEmpty()) null else block(this)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val accessToken = edtAccessToken.text?.toString()?.isTextNotEmpty { it } ?: "94dbf63897c3dbf7c60a1b1f6866b7cf70bd0adafcef323eb1da606a15e9d2e4"
        btnStart.setOnClickListener {
            beSDK.getInstance()
                .build(
                    Startbe.StartBuilder()
                    .setAccessToken(accessToken)
                    .setLanguage(Language.VI))
                .start(this)
        }

        btnLogout.setOnClickListener {
            beSDK.logOut()
        }

    }
}