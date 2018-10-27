package me.dmitvitalii.shiva

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

fun Intent.setPackage(editText: EditText) {
    val text = editText.text.toString()
    if (text.isNotEmpty()) {
        `package` = text
    }
}

fun Intent.setCategory(editText: EditText) {
    val text = editText.text.toString()
    if (text.isNotEmpty()) {
        addCategory(text)
    }
}
