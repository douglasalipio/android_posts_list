package com.baseproject.interview.data.remote

import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.AppRepository
import io.reactivex.disposables.Disposable

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    override fun requestData() = apiHelper.getData()

}