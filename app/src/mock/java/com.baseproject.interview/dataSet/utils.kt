package com.baseproject.interview.dataSet

import kotlin.random.Random


fun numberRandom(): Int {
    val randomNumber = List(10) { Random.nextInt(0, 10) }
    return randomNumber[Random.nextInt(randomNumber.size)]
}

fun stringRandom(): String {
    val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return (1..source.length)
        .map { Random.nextInt(0, source.length) }
        .map(source::get)
        .joinToString("")
}
