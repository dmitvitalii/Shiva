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

    private var currentButton: Position = Position.START

    private lateinit var buttonStart: Button
    private lateinit var buttonCenter: Button
    private lateinit var buttonEnd: Button

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
        buttonStart = root.findViewById(R.id.startButton)
        buttonCenter = root.findViewById(R.id.centerButton)
        buttonEnd = root.findViewById(R.id.endButton)

        buttonStart.setOnTouchListener { v, _ -> onButtonTouched(v as Button, Position.START) }
        buttonCenter.setOnTouchListener { v, _ -> onButtonTouched(v as Button, Position.CENTER) }
        buttonEnd.setOnTouchListener { v, _ -> onButtonTouched(v as Button, Position.END) }
    }

    private fun onButtonTouched(button: Button, position: Position): Boolean {
        currentButton = position
        button.performClick()
        button.isPressed = true
        getExcept(button).forEach { it.isPressed = false }
        return true
    }

    private fun getButton(position: Position) = when (position) {
        Position.START -> buttonStart
        Position.CENTER -> buttonCenter
        Position.END -> buttonEnd
    }

    private fun getExcept(button: Button) = arrayOf(buttonStart, buttonCenter, buttonEnd).filter { it != button }

    fun setText(text: String, button: Position) {
        getButton(button).text = text
    }

    fun setGap(gap: Int) {
        buttonCenter.setPaddingRelative(gap, buttonCenter.paddingTop, gap, buttonCenter.paddingBottom)
    }
}