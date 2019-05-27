package com.babylon.mesquita.interview.data.remote

import com.babylon.mesquita.interview.data.Author
import com.babylon.mesquita.interview.data.Avatar
import com.babylon.mesquita.interview.data.Comment
import com.babylon.mesquita.interview.data.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

const val BASE_URL = " https://jsonplaceholder.typicode.com/"
const val AVATAR_URL = "https://randomuser.me/api/?inc=picture"


interface ApiHelper {

    @GET("posts")
    fun getPosts(): Observable<List<Post>>

    @GET("/users")
    fun getAuthors(): Observable<List<Author>>

    @GET("/comments")
    fun getComments(): Observable<List<Comment>>

    @GET
    fun getAvatars(
        @Url url: String = AVATAR_URL,
        @Query("results") totalAvatars: String
    ): Observable<Avatar>
}