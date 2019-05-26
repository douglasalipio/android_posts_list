package com.babylon.mesquita.interview.data.remote

import com.babylon.mesquita.interview.data.Author
import com.babylon.mesquita.interview.data.Comment
import com.babylon.mesquita.interview.data.Post
import io.reactivex.Observable
import retrofit2.http.GET

const val BASE_URL = " https://jsonplaceholder.typicode.com/"

interface ApiHelper {

    @GET("posts")
    fun getPosts(): Observable<List<Post>>

    @GET("/users")
    fun getAuthors(): Observable<List<Author>>

    @GET("/comments")
    fun getComments(): Observable<List<Comment>>

}