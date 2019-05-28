package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.*
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    override fun requestAvatars(totalAvatar: Int) = remoteDataSource.requestAvatars(totalAvatar)

    override fun requestData(): Observable<Triple<List<PostDTO>, List<CommentDTO>, List<AuthorDTO>>> {
        val postsResponse = remoteDataSource.requestPosts()
        val authorsResponse = remoteDataSource.requestAuthors()
        val commentsResponse = remoteDataSource.requestComments()
        return Observables.zip(postsResponse, commentsResponse, authorsResponse)
    }

}