package com.babylon.mesquita.interview.data

import io.reactivex.Flowable


interface AppDataSource {

    fun requestData(): Flowable<List<Feature>>
}