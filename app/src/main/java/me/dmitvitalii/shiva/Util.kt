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

import android.content.ComponentName
import android.content.Intent
import android.widget.EditText

const val ACTIVITY = 0
const val SERVICE = 1
const val BROADCAST = 2

fun Intent.setAction(editText: EditText) {
    val text = editText.text.toString()
    if (text.isNotEmpty()) {
        action = text
    }
}

fun Intent.setComponent(packageText: EditText, activityText: EditText) {
    val aPackage = packageText.text.toString()
    val activity = activityText.text.toString()
    if (aPackage.isNotEmpty()) {
        if (activity.isNotEmpty()) {
            component = ComponentName(aPackage, activity)
        } else {
            `package` = aPackage
        }
    }
}

fun Intent.setCategory(editText: EditText) {
    val text = editText.text.toString()
    if (text.isNotEmpty()) {
        addCategory(text)
    }
}

fun Intent.hasTarget() = !getPackage().isNullOrEmpty() || component != null