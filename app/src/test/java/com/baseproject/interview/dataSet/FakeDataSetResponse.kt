package com.baseproject.interview.dataSet

import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.CommentResponse
import com.babylon.mesquita.interview.data.remote.PostResponse
import com.baseproject.interview.util.numberRandom
import com.baseproject.interview.util.stringRandom

fun fakeCommentResponse() = CommentResponse(
    numberRandom(), numberRandom(), stringRandom(), stringRandom(),
    stringRandom()
)

fun fakeAuthorResponse() = AuthorResponse(
    numberRandom(), stringRandom(), stringRandom(), stringRandom(), fakeAddress(),
    stringRandom(), stringRandom(), fakeCompany(), stringRandom()
)

fun fakeCommentsResponse(): List<CommentResponse> {
    val fakeList = mutableListOf<CommentResponse>()
    for (index in 0..10) {
        fakeList.add(fakeCommentResponse())
    }
    return fakeList
}

fun fakeAuthorsResponse(): List<AuthorResponse> {
    val fakeList = mutableListOf<AuthorResponse>()
    for (index in 0..10) {
        fakeList.add(fakeAuthorResponse())
    }
    return fakeList
}
fun fakePostsResponse(): List<PostResponse> {
    val fakeList = mutableListOf<PostResponse>()
    for (index in 0..10) {
        fakeList.add(fakePostResponse())
    }
    return fakeList
}

fun fakePostResponse() = PostResponse(numberRandom(), numberRandom(), stringRandom(), stringRandom(), stringRandom())

fun fakeAvatarUrl(totalUrl: Int): MutableList<String> {
    val urls = mutableListOf<String>()
    for (index in 0..totalUrl) {
        urls.add(stringRandom())
    }
    return urls
}