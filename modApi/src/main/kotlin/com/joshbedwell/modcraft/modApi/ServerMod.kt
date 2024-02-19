package com.joshbedwell.modcraft.modApi

import com.joshbedwell.modcraft.common.Message
import com.joshbedwell.modcraft.common.Player

interface ServerMod {
    val server: Int
    companion object {
        fun construct(server: Int): ServerMod {
            return ServerMod(override val server: server)
        }
    }
    fun onConnect(player: Player) {}
    fun onDisconnect(player: Player) {}

    fun onGetMessage(message: Message): Message {
        return message
    }
}