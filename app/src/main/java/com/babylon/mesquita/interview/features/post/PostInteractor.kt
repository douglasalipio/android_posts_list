package com.babylon.mesquita.interview.features.post


import com.babylon.mesquita.interview.data.*
import javax.inject.Inject

class PostInteractor @Inject constructor(private val appRepository: AppDataSource) :
    PostContract.Interactor {

    interface GetPostCallback {
        fun onPostLoaded(posts: List<Post>)
        fun onPostNotAvailable()
    }

    override suspend fun getPosts(getPostsCallback: GetPostCallback) {
        val commentResponse = appRepository.requestCommentAsync().await()
        val authorResponse = appRepository.requestAuthorsAsync().await()
        val postsResponse = appRepository.requestPostAsync().await()
        val avatarResponse = appRepository.requestAvatarsAsync(postsResponse.size).await().makeAvatars()
        val posts = postsResponse.makePosts(commentResponse, authorResponse, avatarResponse.toMutableList())
        if (posts.isNotEmpty())
            getPostsCallback.onPostLoaded(posts)
        else
            getPostsCallback.onPostNotAvailable()
    }
}


