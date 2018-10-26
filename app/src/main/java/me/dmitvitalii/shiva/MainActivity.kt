package me.dmitvitalii.shiva

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    val ACTIVITY  = 0
    val SERVICE   = 1
    val BROADCAST = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSendClicked(button: View) {
        val intent = Intent()
        with(intent) {
            action = text_action.text.toString()
            setPackage(text_package.text.toString())
            addCategory(text_category.text.toString())
        }
        start(intent)
    }

    fun start(intent: Intent) {
        when (switch_components.checkedPosition) {
            ACTIVITY  -> startActivity(intent)
            SERVICE   -> startService(intent)
            BROADCAST -> sendBroadcast(intent)
        }
    }
}
