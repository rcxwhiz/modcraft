package com.joshbedwell.modcraft.modApi

import com.joshbedwell.modcraft.common.Message

interface Mod {
    val name: String

    fun onSend(message: Message): Message {
        return message
    }
}