package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.*
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import kotlinx.coroutines.Deferred
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {


    override fun requestPostAsync() = remoteDataSource.requestPostAsync()

    override fun requestCommentAsync() = remoteDataSource.requestCommentAsync()

    override fun requestAuthorsAsync() = remoteDataSource.requestAuthorsAsync()

    override fun requestAvatarsAsync(totalAvatars: Int) = remoteDataSource.requestAvatarsAsync(totalAvatars)

}