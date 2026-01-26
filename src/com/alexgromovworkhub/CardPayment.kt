package com.alexgromovworkhub

class CardPayment(
    private val cardNumber: String,
) : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        if (amount <= 0.0) return false
        return true
    }

}