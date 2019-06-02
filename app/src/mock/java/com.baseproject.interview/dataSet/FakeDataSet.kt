package com.baseproject.interview.dataSet

import com.babylon.mesquita.interview.data.Author
import com.babylon.mesquita.interview.data.Comment
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.data.remote.Address
import com.babylon.mesquita.interview.data.remote.Company
import com.babylon.mesquita.interview.data.remote.Geo

fun listOfFakePosts(): MutableList<Post> {
    val fakePosts = mutableListOf<Post>()
    for (i in 1..10) {
        val fakeComments = mutableListOf<Comment>()
        fakeComments.add(fakeComment())
        val post = Post(
            numberRandom(), stringRandom(), stringRandom(), fakeComments,
            fakeAuthor(), stringRandom()
        )
        fakePosts.add(post)
    }
    return fakePosts
}

fun fakePost() = Post(numberRandom(), stringRandom(), stringRandom(), fakeComments(), fakeAuthor(), stringRandom())

fun fakeComments(): List<Comment> {
    val comments = mutableListOf<Comment>()
    for (index in 1..10) {
        comments.add(fakeComment())
    }
    return comments
}

fun fakeComment() = Comment(numberRandom(), stringRandom(), stringRandom(), stringRandom(), numberRandom())

fun fakeAuthor() = Author(
    numberRandom(), stringRandom(), stringRandom(),
    stringRandom(), fakeAddress(), stringRandom(),
    stringRandom(), fakeCompany(), stringRandom()
)

fun fakeAddress() = Address(
    stringRandom(), stringRandom(), stringRandom(), stringRandom(),
    fakeGeo()
)

fun fakeCompany() = Company(stringRandom(), stringRandom(), stringRandom())

fun fakeGeo() = Geo(stringRandom(), stringRandom())

