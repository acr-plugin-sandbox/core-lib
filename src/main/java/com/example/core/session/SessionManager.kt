package com.example.core.session

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/** Holds the signed-in session for the whole process. */
class SessionManager internal constructor(private val store: SessionStore) {

    private val listeners = mutableListOf<SessionListener>()

    @Volatile
    private var session: Session? = null

    fun current(): Session? = session

    fun addListener(listener: SessionListener) {
        listeners += listener
    }

    fun removeListener(listener: SessionListener) {
        listeners -= listener
    }

    suspend fun refresh(): Session? = withContext(Dispatchers.IO) {
        val restored = store.load()
        session = restored
        listeners.forEach { it.onSessionChanged(restored) }
        restored
    }

    fun signOut() {
        session = null
        store.clear()
        listeners.forEach { it.onSessionChanged(null) }
    }

    /** When the current session expires, in epoch milliseconds. */
    fun expiresAt(): Long? = session?.expiresAtMillis

    companion object {
        val instance: SessionManager by lazy { SessionManager(InMemorySessionStore()) }
    }
}
