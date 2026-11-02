package com.example.core.session

internal interface SessionStore {
    fun load(): Session?
    fun save(session: Session)
    fun clear()
}

internal class InMemorySessionStore : SessionStore {
    private var session: Session? = null

    override fun load(): Session? = session

    override fun save(session: Session) {
        this.session = session
    }

    override fun clear() {
        session = null
    }
}
