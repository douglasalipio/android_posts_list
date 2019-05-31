package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.AvatarResponse
import com.babylon.mesquita.interview.data.remote.CommentResponse
import com.babylon.mesquita.interview.data.remote.PostResponse
import io.reactivex.Observable

interface AppDataSource {

    fun requestPostsAndComments(): Observable<Pair<List<PostResponse>, List<CommentResponse>>>? {
        return null
    }

    fun requestAuthorsAndAvatars(): Observable<List<AuthorResponse>>

}