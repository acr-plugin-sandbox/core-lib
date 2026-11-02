package com.example.core.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.example.core.R

class StatusBadgeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : FrameLayout(context, attrs) {

    private val label: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_status_badge, this, true)
        label = findViewById(R.id.status_label)
    }

    fun bind(signedIn: Boolean) {
        label.text = if (signedIn) "Signed in" else "Signed out"
    }
}
