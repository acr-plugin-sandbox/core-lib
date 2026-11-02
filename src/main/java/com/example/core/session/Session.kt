package com.example.core.session

data class Session(
    val userName: String,
    val token: String,
    val expiresAtMillis: Long,
)
