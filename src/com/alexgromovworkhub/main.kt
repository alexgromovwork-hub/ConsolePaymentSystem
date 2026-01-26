package com.alexgromovworkhub
val payments: List<PaymentMethod> = listOf(
    CardPayment("1234"),
    CashPayment(),
    CardPayment("4321"),
)
fun main() {
    for(payment in payments) {
        payment.pay(100.0)
    }
}