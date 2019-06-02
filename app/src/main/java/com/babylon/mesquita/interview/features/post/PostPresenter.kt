package com.babylon.mesquita.interview.features.post

import com.babylon.mesquita.interview.di.ActivityScoped
import org.secfirst.umbrella.misc.AppExecutors.Companion.uiContext
import org.secfirst.umbrella.misc.launchSilent
import javax.inject.Inject

@ActivityScoped
class PostPresenter @Inject constructor(private val interactor: PostContract.Interactor) :
    PostContract.Presenter {

    private var view: PostContract.View? = null

    override fun loadDataBlog() {
        launchSilent(uiContext) {
            interactor.let {
                val posts = it.getPosts()
                if (posts.isNotEmpty())
                    view?.showPosts(posts)
                else
                    view?.showDataError()
            }
        }
    }

    override fun <T> takeView(view: T) {
        this.view = view as PostContract.View
    }

    override fun dropView() {
        view = null
    }
}
