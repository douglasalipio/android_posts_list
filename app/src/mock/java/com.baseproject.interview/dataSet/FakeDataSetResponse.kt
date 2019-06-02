package com.baseproject.interview.dataSet

import com.babylon.mesquita.interview.data.remote.*

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

fun fakeAvatarUrl(): AvatarResponse? {
    val fakeAvatar: AvatarResponse?
    val result = Result(Picture(stringRandom(), stringRandom(), stringRandom()))
    val results = mutableListOf<Result>()
    results.add(result)
    fakeAvatar = AvatarResponse(results)
    return fakeAvatar
}