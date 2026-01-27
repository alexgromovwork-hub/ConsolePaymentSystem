package com.alexgromovworkhub
val payments: List<PaymentMethod> = listOf(
    CardPayment("1234"),
    CashPayment(),
    CardPayment("4321"),
)
fun main() {
    for(payment in payments) {
        PaymentUseCase(payment, SmsSender()).execute(100.0)
    }

}

class PaymentUseCase(
    private val paymentMethod: PaymentMethod,
    private val notifier: NotificationSender
) {
    fun execute(amount: Double) {
        if(paymentMethod.pay(amount)) {
            notifier.sendMessage("Payment successful | $amount")
        }
    }
}