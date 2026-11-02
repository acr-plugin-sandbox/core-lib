package com.example.core.session

import org.junit.Assert.assertEquals
import org.junit.Test

class SessionTest {
    @Test
    fun keepsUserName() {
        assertEquals("ada", Session(userName = "ada", token = "t", expiresAtMillis = 0L).userName)
    }
}
