package com.baseproject.interview.data

import com.baseproject.interview.data.remote.RemoteDataSource

class AppRepository(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    override fun getTasks() = remoteDataSource.getTasks()
}