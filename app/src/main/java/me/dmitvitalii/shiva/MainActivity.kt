/*
 * Copyright © 2018 Vitalii Dmitriev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        // TODO: implement an IntentBuilder instead
        val intent = with(Intent()) {
            setAction(text_action)
            setComponent(text_package, text_activity)
            setCategory(text_category)
            this
        }
        if (intent.hasTarget()) {
            start(intent)
        } else {
            Toast.makeText(this, "Package is required", Toast.LENGTH_SHORT).show()
        }
    }

    fun start(intent: Intent) {
        when (switchView.currentButton) {
            TripleSwitchView.Position.START -> startActivity(intent)
            TripleSwitchView.Position.CENTER -> startService(intent)
            TripleSwitchView.Position.END -> sendBroadcast(intent)
        }
    }
}