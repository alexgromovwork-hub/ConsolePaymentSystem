package com.alexgromovworkhub

import kotlin.system.exitProcess

class ConsoleUI {
    var paymentMethod: PaymentMethod? = null
    fun cardInput(): String? {
        println("Enter card number")
        val input = readln()
        if (input.isBlank()) return null
        if (input.toIntOrNull() == null) return null
        return input
    }
    fun inputDoubleCheck(input: String): Boolean{
        return input.toDoubleOrNull() != null
    }

    fun launch(){
        println("Hello. It is a payment app")//greeting and info
        while (true) {
            println("Choose payment method:\n 1. Card\n 2. Cash")
            val paymentMethodStr = readln()
            var cardNumber: String?
            when (paymentMethodStr) {//take input of payment method and check it
                "1" -> {

                    do {
                        cardNumber = cardInput()
                        if (cardNumber != null) paymentMethod = CardPayment(cardNumber)
                        else println("Card number is invalid")
                    } while (cardNumber == null)
                }

                "2" -> paymentMethod = CashPayment()
                else -> {
                    println("There's no such option")
                    continue
                }
            }
            println("Enter money amount:")//take input of payment amount, method is checking amount correctness automatically
            val amountStr = readln()
            var amount: Double
            if (inputDoubleCheck(amountStr)) {
                amount = amountStr.toDouble()
            } else {
                println("You need to enter a valid number")
                continue
            }
            println("Choose the notification method:\n 1. Email\n 2. SMS") //take input of notification method and check it
            val notifierStr = readln()
            val notifier = when (notifierStr) {
                "1" -> EmailSender()
                "2" -> SmsSender()
                else -> {
                    println("There's no such option")
                    continue
                }
            }
            val useCase = PaymentUseCase(paymentMethod!!, notifier)
            useCase.execute(amount)//notify
            println("Choose what to do next:\n 1. Leave the app\n 2. Make new payment")
            if(readln() == "1") exitProcess(0) //repeat
        }
    }
}