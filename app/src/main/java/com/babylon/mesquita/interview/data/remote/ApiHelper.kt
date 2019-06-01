package com.babylon.mesquita.interview.data.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

const val BASE_URL = " https://jsonplaceholder.typicode.com/"
const val AVATAR_URL = "https://randomuser.me/api/?inc=picture"
const val RANDOM_IMAGE = "https://loremflickr.com/320/240/brazil,rio"

interface ApiHelper {

    @GET("/posts")
    fun getPosts(): Observable<List<PostResponse>>

    @GET("/users")
    fun getAuthors(): Observable<List<AuthorResponse>>

    @GET("/comments")
    fun getComments(): Observable<List<CommentResponse>>

    @GET
    fun getAvatars(
        @Url url: String = AVATAR_URL,
        @Query("results") totalAvatars: Int
    ): Observable<AvatarResponse>
}