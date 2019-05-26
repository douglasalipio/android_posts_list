package com.babylon.mesquita.interview.data

import io.reactivex.Observable


interface AppDataSource {

    fun requestPosts(): Observable<List<Post>>

    fun requestAuthors(): Observable<List<Author>>

    fun requestComments(): Observable<List<Comment>>
}