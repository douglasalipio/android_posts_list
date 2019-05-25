package com.baseproject.interview.data.remote

import com.baseproject.interview.data.Feature
import io.reactivex.Flowable
import retrofit2.http.GET

const val BASE_URL = "https://www.mocky.io"

interface ApiHelper {

    @GET("/v2/5ce46666310000a191742d1c")
    fun getData(): Flowable<List<Feature>>
}