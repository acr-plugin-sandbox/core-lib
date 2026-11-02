package com.example.core.session

import android.content.SharedPreferences

@Deprecated("Sessions are no longer persisted in SharedPreferences.")
internal class LegacySessionStore(private val prefs: SharedPreferences) : SessionStore {
    override fun load(): Session? {
        val token = prefs.getString("token", null) ?: return null
        return Session(
            userName = prefs.getString("user", "").orEmpty(),
            token = TokenCodec.decode(token),
            expiresAtMillis = prefs.getLong("expires_at", 0L),
        )
    }

    override fun save(session: Session) {
        prefs.edit()
            .putString("user", session.userName)
            .putString("token", TokenCodec.encode(session.token))
            .putLong("expires_at", session.expiresAtMillis)
            .apply()
    }

    override fun clear() {
        prefs.edit().clear().apply()
    }
}
