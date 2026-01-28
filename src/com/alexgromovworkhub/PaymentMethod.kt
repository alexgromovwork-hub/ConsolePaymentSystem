package com.alexgromovworkhub

interface PaymentMethod {
    fun pay(amount: Double): Boolean
}

class CashPayment : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        if (amount <= 0.0) return false
        return true
    }
}

class CardPayment(
    private val cardNumber: String,
) : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        if (amount <= 0.0) return false
        return true
    }
}