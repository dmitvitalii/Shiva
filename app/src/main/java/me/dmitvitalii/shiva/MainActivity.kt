package me.dmitvitalii.shiva

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSendClicked(button: View) {
        val intent = Intent()
        // TODO: implement an IntentBuilder instead
        with(intent) {
            setAction(text_action)
            setComponent(text_package, text_activity)
            setCategory(text_category)
        }
        if (intent.hasTarget()) {
            start(intent)
        } else {
            Toast.makeText(this, "Package is required", Toast.LENGTH_SHORT).show()
        }
    }

    fun start(intent: Intent) {
        when (switch_components.checkedPosition) {
            ACTIVITY  -> startActivity(intent)
            SERVICE   -> startService(intent)
            BROADCAST -> sendBroadcast(intent)
        }
    }
}
