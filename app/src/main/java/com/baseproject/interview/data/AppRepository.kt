package com.baseproject.interview.data

import com.baseproject.interview.data.remote.RemoteDataSource
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    override fun requestData() = remoteDataSource.requestData()
}