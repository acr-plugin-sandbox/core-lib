package com.example.core.session

fun interface SessionListener {
    fun onSessionChanged(session: Session?)
}
