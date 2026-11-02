package com.example.core.session

import android.util.Base64

internal object TokenCodec {
    fun encode(token: String): String {
        require(token.isNotBlank()) { "token must not be blank" }
        return Base64.encodeToString(token.toByteArray(Charsets.UTF_8), Base64.NO_WRAP)
    }

    fun decode(encoded: String): String =
        String(Base64.decode(encoded, Base64.NO_WRAP), Charsets.UTF_8)
}
