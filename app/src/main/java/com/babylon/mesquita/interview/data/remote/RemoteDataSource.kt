package com.babylon.mesquita.interview.data.remote

import com.babylon.mesquita.interview.data.AppDataSource

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    fun requestPosts() = apiHelper.getPosts()

    fun requestAuthors() = apiHelper.getAuthors()

    fun requestComments() = apiHelper.getComments()

    override fun requestAvatars(totalAvatar: Int) = apiHelper.getAvatars(AVATAR_URL, totalAvatar.toString())
}