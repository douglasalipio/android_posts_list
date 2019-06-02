package com.babylon.mesquita.interview.data.remote

import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

const val BASE_URL = " https://jsonplaceholder.typicode.com/"
const val AVATAR_URL = "https://randomuser.me/api/?inc=picture"
const val RANDOM_IMAGE = "https://loremflickr.com/320/240/brazil,rio"

interface ApiHelper {

    @GET("/posts")
    fun getPostsAsync(): Deferred<List<PostResponse>>

    @GET("/users")
    fun getAuthorsAsync(): Deferred<List<AuthorResponse>>

    @GET("/comments")
    fun getCommentsAsync(): Deferred<List<CommentResponse>>

    @GET
    fun getAvatarsAsync(
        @Url url: String = AVATAR_URL,
        @Query("results") totalAvatars: Int
    ): Deferred<AvatarResponse>
}