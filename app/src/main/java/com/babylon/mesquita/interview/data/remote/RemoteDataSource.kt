package com.babylon.mesquita.interview.data.remote

import com.babylon.mesquita.interview.data.AppDataSource

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    override fun requestData() = apiHelper.getData()

}