package com.alexgromovworkhub

class PaymentUseCase(
    private val paymentMethod: PaymentMethod,
    private val notifier: NotificationSender
) {
    fun execute(amount: Double) {
        if(paymentMethod.pay(amount)) {
            notifier.sendMessage("Payment successful | $amount")
        } else notifier.sendMessage("Payment failed | $amount")
    }
}