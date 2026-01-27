package com.alexgromovworkhub

abstract class NotificationSender {
    fun sendMessage(message : String) {
        if (message.isBlank()) return
        sendInternal(message)
    }
    protected abstract fun sendInternal(message: String)
}