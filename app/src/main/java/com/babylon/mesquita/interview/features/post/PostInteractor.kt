package com.babylon.mesquita.interview.features.post


import com.babylon.mesquita.interview.data.*
import javax.inject.Inject

class PostInteractor @Inject constructor(private val appRepository: AppDataSource) :
    PostContract.Interactor {

    override suspend fun getPosts(): List<Post> {
        val commentResponse = appRepository.requestCommentAsync().await()
        val authorResponse = appRepository.requestAuthorsAsync().await()
        val postsResponse = appRepository.requestPostAsync().await()
        val avatarResponse = appRepository.requestAvatarsAsync(postsResponse.size).await().makeAvatars()
        return postsResponse.makePosts(commentResponse, authorResponse, avatarResponse.toMutableList())
    }
}


