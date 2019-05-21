package com.baseproject.interview.data.remote

import com.baseproject.interview.data.AppDataSource

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    override fun getTasks() = apiHelper.getData()

}