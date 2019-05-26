package com.baseproject.interview

import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.post.PostContract
import com.babylon.mesquita.interview.post.PostInteractor
import com.babylon.mesquita.interview.post.PostPresenter
import com.nhaarman.mockitokotlin2.capture
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*


class PostPresenterTest {
    @Mock
    private lateinit var appRepository: AppDataSource
    @Mock
    private lateinit var view: PostContract.View
    @Mock
    private lateinit var interactor: PostContract.Interactor
    @Captor
    private lateinit var getPostCallbackCaptor: ArgumentCaptor<PostInteractor.GetPostCallback>
    private lateinit var presenter: PostPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PostPresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should return a list of posts`() {
        val fakePosts = listOfFakePosts()
        presenter.loadPosts()
        //`when`(appRepository.requestData()).thenReturn(Flowable.just(features))
        //verify(appRepository).requestData().subscribe()
        verify(interactor).requestPosts(capture(getPostCallbackCaptor))
        getPostCallbackCaptor.value.onPostLoaded(fakePosts)
        verify(view).showPosts(fakePosts)
    }

    @Test
    fun `should show a error message`() {
        presenter.loadPosts()
        verify(interactor).requestPosts(capture(getPostCallbackCaptor))
        getPostCallbackCaptor.value.onPostNotAvailable("posts not available.")
        verify(view).showDataError()
    }
}