package com.example.core.session

import org.junit.Assert.assertEquals
import org.junit.Test

class SessionLabelTest {
    @Test
    fun showsTheUserName() {
        assertEquals("ada", sessionLabel(Session(userName = "ada", token = "t", expiresAtMillis = 0L)))
    }

    @Test
    fun showsSignedOutWithoutASession() {
        assertEquals("Signed out", sessionLabel(null))
    }
}
