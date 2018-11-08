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

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout

class TripleSwitchView : LinearLayout {

    var currentButton: Position = Position.START
        private set

    private val buttons = HashMap<Button, Position>(3)

    enum class Position {
        START, CENTER, END
    }

    constructor(context: Context) : super(context, null) {
        init(context)
    }

    constructor(context: Context, attr: AttributeSet?) : super(context, attr, 0) {
        init(context)
    }

    constructor(context: Context, attr: AttributeSet?, styleAttr: Int) : super(context, attr, styleAttr) {
        init(context)
    }

    @TargetApi(21)
    constructor(context: Context, attr: AttributeSet?, styleAttr: Int, styleRes: Int)
            : super(context, attr, styleAttr, styleRes) {
        init(context)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun init(context: Context) {
        val root = LayoutInflater.from(context).inflate(R.layout.switch_view, this)
        buttons[root.findViewById(R.id.startButton)] = Position.START
        buttons[root.findViewById(R.id.centerButton)] = Position.CENTER
        buttons[root.findViewById(R.id.endButton)] = Position.END
        buttons.forEach { it.key.setOnTouchListener { v, _ -> onButtonTouched(v as Button) } }
    }

    private fun onButtonTouched(button: Button): Boolean {
        currentButton = buttons[button] ?: currentButton
        button.performClick()
        button.isPressed = true
        buttons.filterNot { it.key == button }
               .forEach { it.key.isPressed = false }
        return true
    }

}