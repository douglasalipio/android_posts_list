package com.baseproject.interview.data.remote

import io.reactivex.Flowable
import retrofit2.http.GET

const val BASE_URL = "https://api.secfirst.org/"

interface ApiHelper {

    @GET("api/android")
    fun getData(): Flowable<List<String>>
}