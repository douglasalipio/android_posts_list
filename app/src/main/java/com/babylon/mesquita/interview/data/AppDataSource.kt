package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.AvatarResponse
import com.babylon.mesquita.interview.data.remote.CommentResponse
import com.babylon.mesquita.interview.data.remote.PostResponse
import io.reactivex.Observable

interface AppDataSource {

    fun requestAvatars(totalAvatars: Int): Observable<AvatarResponse>

    fun requestData(): Observable<Triple<List<PostResponse>, List<CommentResponse>, List<AuthorResponse>>>? {
        return null
    }

    fun requestAuthors(): Observable<List<AuthorResponse>>
}