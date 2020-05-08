package com.example.toast

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class TaskItemDoneView : ConstraintLayout {
    lateinit var textView: TextView
    lateinit var removeButton: ImageView

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onFinishInflate() {
        super.onFinishInflate()

        textView = findViewById(R.id.task_text_view)

        removeButton = findViewById(R.id.remove_button)
    }
}