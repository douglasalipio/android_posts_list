package com.babylon.mesquita.interview.data.remote

import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.Author
import com.babylon.mesquita.interview.data.Comment
import com.babylon.mesquita.interview.data.Post
import io.reactivex.Observable

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    override fun requestPosts() = apiHelper.getPosts()

    override fun requestAuthors() = apiHelper.getAuthors()

    override fun requestComments() = apiHelper.getComments()

    override fun requestAvatars(totalAvatars: Int) = apiHelper.getAvatars(AVATAR_URL, totalAvatars.toString())
}