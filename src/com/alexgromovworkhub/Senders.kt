package com.alexgromovworkhub

class EmailSender: NotificationSender() {
    override fun sendInternal(message: String) {
        println("Sending \"$message\" on email")
    }

}
class SmsSender: NotificationSender() {
    override fun sendInternal(message: String) {
        println("Sending \"$message\" via SMS")    }
}