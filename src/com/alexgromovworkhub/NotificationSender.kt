package com.alexgromovworkhub

abstract class NotificationSender {
    fun sendMessage(message : String) {
        if (message.isBlank()) return
        sendInternal(message)
    }
    protected abstract fun sendInternal(message: String)
}
class EmailSender: NotificationSender() {
    override fun sendInternal(message: String) {
        println("Sending \"$message\" on email")
    }

}
class SmsSender: NotificationSender() {
    override fun sendInternal(message: String) {
        println("Sending \"$message\" via SMS")    }
}