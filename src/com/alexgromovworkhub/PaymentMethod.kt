package com.alexgromovworkhub

interface PaymentMethod {
    fun pay(amount: Double): Boolean
}