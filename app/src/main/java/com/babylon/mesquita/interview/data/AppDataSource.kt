package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.AuthorDTO
import com.babylon.mesquita.interview.data.remote.AvatarDTO
import com.babylon.mesquita.interview.data.remote.CommentDTO
import com.babylon.mesquita.interview.data.remote.PostDTO
import io.reactivex.Observable

interface AppDataSource {

    fun requestData(): Observable<Triple<List<PostDTO>, List<CommentDTO>, List<AuthorDTO>>>? {
        return null
    }

    fun requestAvatars(totalAvatar: Int): Observable<AvatarDTO>
}