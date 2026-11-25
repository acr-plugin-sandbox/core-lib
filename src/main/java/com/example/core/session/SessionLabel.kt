package com.example.core.session

/**
 * Returns the text a screen shows for [session]: the user name, or
 * `Signed out` when there is no session. It never throws.
 */
fun sessionLabel(session: Session?): String = session?.userName ?: "Signed out"
