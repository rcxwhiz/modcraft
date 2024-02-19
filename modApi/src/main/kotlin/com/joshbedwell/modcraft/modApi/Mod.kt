package com.joshbedwell.modcraft.modApi

import com.joshbedwell.modcraft.common.Message

interface Mod : ModMetadata {
    companion object {
        val INSTANCE: Mod
    }

    fun onSend(message: Message): Message {
        return message
    }
}