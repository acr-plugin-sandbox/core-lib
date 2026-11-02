package com.example.core.session

internal object SessionExpiry {
    fun isExpired(session: Session, nowMillis: Long): Boolean {
        if (session.expiresAtMillis <= nowMillis) {
            return true
        } else {
            return false
        }
    }
}
