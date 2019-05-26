package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.RemoteDataSource
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    override fun requestData() = remoteDataSource.requestData()
}