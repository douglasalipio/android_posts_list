package com.babylon.mesquita.interview.post

import android.util.Log
import com.babylon.mesquita.interview.data.Avatar
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.di.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PostPresenter @Inject constructor(private val interactor: PostContract.Interactor) :
    PostContract.Presenter {


    private var view: PostContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as PostContract.View
    }

    override fun loadPosts() {
        view?.let {
            interactor.requestPosts(object : PostInteractor.GetPostCallback {
                override fun onPostLoaded(posts: List<Post>) {
                    it.showPosts(posts)
                }

                override fun onPostNotAvailable(strError: String) {
                    it.showDataError()
                }
            })
            interactor.requestAvatars(object : PostInteractor.GetAvatarCallback {
                override fun onAvatarNotAvailable(strError: String) {
                    Log.e("test", "Error avatar!")
                }

                override fun onAvatarLoaded(avatar: Avatar) {
                    Log.e("test", avatar.toString())
                }


            })
        }
    }

    override fun loadAuthors() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadComments() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dropView() {
        view = null
    }
}
