package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.AvatarResponse
import com.babylon.mesquita.interview.data.remote.CommentResponse
import com.babylon.mesquita.interview.data.remote.PostResponse
import kotlinx.coroutines.Deferred

interface AppDataSource {

    fun requestAvatarsAsync(totalAvatars: Int): Deferred<AvatarResponse>

    fun requestPostAsync(): Deferred<List<PostResponse>>

    fun requestCommentAsync(): Deferred<List<CommentResponse>>

    fun requestAuthorsAsync(): Deferred<List<AuthorResponse>>
}