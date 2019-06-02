package com.babylon.mesquita.interview.data.remote

import com.babylon.mesquita.interview.data.AppDataSource

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    override fun requestPostAsync() = apiHelper.getPostsAsync()

    override fun requestCommentAsync() = apiHelper.getCommentsAsync()

    override fun requestAvatarsAsync(totalAvatars: Int) = apiHelper.getAvatarsAsync(AVATAR_URL, totalAvatars)

    override fun requestAuthorsAsync() = apiHelper.getAuthorsAsync()

}