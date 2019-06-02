package com.babylon.mesquita.interview.features.post

import com.babylon.mesquita.interview.data.Author
import com.babylon.mesquita.interview.data.Comment
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.foundation.BasePresenter
import com.babylon.mesquita.interview.foundation.BaseView
import com.babylon.mesquita.interview.data.remote.PostResponse
import com.babylon.mesquita.interview.foundation.BaseInteractor

interface PostContract {

    interface View : BaseView<Presenter> {
        fun showPosts(posts: List<Post>)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadDataBlog()
    }

    interface Interactor : BaseInteractor {
        suspend fun getPosts(): List<Post>
    }
}