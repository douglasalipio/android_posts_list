package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.*
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {


    override fun requestAuthors() = remoteDataSource.requestAuthors()

    override fun requestAvatars(totalAvatars: Int) = remoteDataSource.requestAvatars(totalAvatars)

    override fun requestData(): Observable<Triple<List<PostResponse>, List<CommentResponse>, List<AuthorResponse>>> {
        val postsResponse = remoteDataSource.requestPosts()
        val commentsResponse = remoteDataSource.requestComments()
        val authorsResponse = remoteDataSource.requestAuthors()
        return Observables.zip(postsResponse, commentsResponse, authorsResponse)
    }
}