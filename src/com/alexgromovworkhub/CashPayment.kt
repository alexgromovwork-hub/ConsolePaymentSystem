package com.alexgromovworkhub

class CashPayment : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        if (amount <= 0.0) return false
        return true
    }
}