package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.RemoteDataSource
import io.reactivex.Observable
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    override fun requestPosts() = remoteDataSource.requestPosts()

    override fun requestAuthors() = remoteDataSource.requestAuthors()

    override fun requestComments() = remoteDataSource.requestComments()

    override fun requestAvatars(totalAvatars: Int) = remoteDataSource.requestAvatars(totalAvatars)

}