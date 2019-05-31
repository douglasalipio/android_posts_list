package com.babylon.mesquita.interview.data.remote

import android.annotation.SuppressLint
import com.babylon.mesquita.interview.data.AppDataSource
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    fun requestPosts() = apiHelper.getPosts()

    fun requestComments() = apiHelper.getComments()

    @SuppressLint("CheckResult")
    override fun requestAuthorsAndAvatars(): Observable<List<AuthorResponse>> {
        val authorResponse = mutableListOf<AuthorResponse>()
        apiHelper.getAuthors()
            .subscribeOn(Schedulers.io())
            .doOnNext {  authorResponse.addAll(it)  }
            .flatMap { apiHelper.getAvatars(AVATAR_URL, it.size.toString()) }
            .subscribe {
                it.results.forEachIndexed { index, result ->
                    authorResponse[index].urlAvatar = result.picture.large
                }
            }
        return Observable.just(authorResponse)
    }
}