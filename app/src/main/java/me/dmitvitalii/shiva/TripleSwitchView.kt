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

import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout

class TripleSwitchView : LinearLayout {

    lateinit var buttonStart: Button
    lateinit var buttonCenter: Button
    lateinit var buttonEnd: Button

    enum class Position {
        START, CENTER, END
    }

    constructor(context: Context, attr: AttributeSet? = null, styleAttr: Int = 0) : super(context, attr, styleAttr) {
        init(context)
    }

    @TargetApi(21)
    constructor(context: Context, attr: AttributeSet? = null, styleAttr: Int = 0, styleRes: Int = 0)
            : super(context, attr, styleAttr, styleRes) {
        init(context)
    }

    private fun init(context: Context) {
        val root = LayoutInflater.from(context).inflate(R.layout.switch_view, this)
        buttonStart  = root.findViewById(R.id.startButton)
        buttonCenter = root.findViewById(R.id.centerButton)
        buttonEnd    = root.findViewById(R.id.endButton)
    }

    fun getButton(position: Position) = when (position) {
        Position.START  -> buttonStart
        Position.CENTER -> buttonCenter
        Position.END    -> buttonEnd
    }

    fun setOnClickListener(listener: OnClickListener, button: Position) {
        getButton(button).setOnClickListener(listener)
    }

    fun setText(text: String, button: Position) {
        getButton(button).text = text
    }

    fun setGap(gap: Int) {
        buttonCenter.setPaddingRelative(gap, buttonCenter.paddingTop, gap, buttonCenter.paddingBottom)
    }
}