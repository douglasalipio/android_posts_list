package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.*
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    override fun requestAuthorsAndAvatars() = remoteDataSource.requestAuthorsAndAvatars()

    override fun requestPostsAndComments(): Observable<Pair<List<PostResponse>, List<CommentResponse>>> {
        val postsResponse = remoteDataSource.requestPosts()
        val commentsResponse = remoteDataSource.requestComments()
        return Observables.zip(postsResponse, commentsResponse)
    }

}