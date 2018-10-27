package me.dmitvitalii.shiva

import android.content.ComponentName
import android.content.Intent
import android.widget.EditText

const val ACTIVITY  = 0
const val SERVICE   = 1
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