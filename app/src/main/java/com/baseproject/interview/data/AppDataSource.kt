package com.baseproject.interview.data

import io.reactivex.Flowable


interface AppDataSource {

    fun getTasks(): Flowable<List<String>>
}