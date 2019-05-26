package com.baseproject.interview

import com.babylon.mesquita.interview.data.Post
import kotlin.random.Random

fun listOfFakePosts(): MutableList<Post> {
    val fakePosts = mutableListOf<Post>()
    for (i in 1..10) {
        val post = Post(numberRandom(), numberRandom(), stringRandom(), stringRandom())
        fakePosts.add(post)
    }
    return fakePosts
}

private fun numberRandom(): Int {
    val randomNumber = List(10) { Random.nextInt(0, 10) }
    return randomNumber[Random.nextInt(randomNumber.size)]
}

private fun stringRandom(): String {
    val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return (1..source.length)
        .map { Random.nextInt(0, source.length) }
        .map(source::get)
        .joinToString("")
}