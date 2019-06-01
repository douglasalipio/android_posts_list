package com.babylon.mesquita.interview.data.remote

import com.babylon.mesquita.interview.data.AppDataSource

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    fun requestPosts() = apiHelper.getPosts()

    fun requestComments() = apiHelper.getComments()

    override fun requestAvatars(totalAvatars: Int) = apiHelper.getAvatars(AVATAR_URL, totalAvatars)

    override fun requestAuthors() = apiHelper.getAuthors()

}