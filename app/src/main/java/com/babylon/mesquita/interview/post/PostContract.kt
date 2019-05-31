package com.babylon.mesquita.interview.post

import com.babylon.mesquita.interview.foundation.BasePresenter
import com.babylon.mesquita.interview.foundation.BaseView
import com.babylon.mesquita.interview.data.remote.PostResponse
import com.babylon.mesquita.interview.foundation.BaseInteractor

interface PostContract {

    interface View : BaseView<Presenter> {
        fun showPosts(posts: List<PostResponse>)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadPosts()
        fun loadAuthors()
    }

    interface Interactor : BaseInteractor {
        fun getPosts(getPostsCallback: PostInteractor.GetPostCallback)
        fun getAuthors(getAuthorsCallback: PostInteractor.GetAuthorCallback)
    }
}