package com.babylon.mesquita.interview.post

import com.babylon.mesquita.interview.foundation.BasePresenter
import com.babylon.mesquita.interview.foundation.BaseView
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.foundation.BaseInteractor

interface PostContract {

    interface View : BaseView<Presenter> {
        fun showPosts(posts: List<Post>)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadPosts()
        fun loadAuthors()
        fun loadComments()
    }

    interface Interactor : BaseInteractor {
        fun requestPosts(getPostsCallback: PostInteractor.GetPostCallback)
        fun requestAvatars(getAvatarsCallback: PostInteractor.GetAvatarCallback)
    }

}