package com.baseproject.interview

import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.feature.FeatureContract
import com.babylon.mesquita.interview.feature.FeatureInteractor
import com.babylon.mesquita.interview.feature.FeaturePresenter
import com.nhaarman.mockitokotlin2.capture
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*


class FeaturePresenterTest {
    @Mock
    private lateinit var appRepository: AppDataSource
    @Mock
    private lateinit var view: FeatureContract.View
    @Mock
    private lateinit var interactor: FeatureContract.Interactor
    @Captor
    private lateinit var getFeatureCallbackCaptor: ArgumentCaptor<FeatureInteractor.GetPostCallback>
    private lateinit var presenter: FeaturePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = FeaturePresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should return a list of posts`() {
        val fakePosts = listOfFakePosts()
        presenter.loadPosts()
        //`when`(appRepository.requestData()).thenReturn(Flowable.just(features))
        //verify(appRepository).requestData().subscribe()
        verify(interactor).requestPosts(capture(getFeatureCallbackCaptor))
        getFeatureCallbackCaptor.value.onPostLoaded(fakePosts)
        verify(view).showPosts(fakePosts)
    }

    @Test
    fun `should show a error message`() {
        presenter.loadPosts()
        verify(interactor).requestPosts(capture(getFeatureCallbackCaptor))
        getFeatureCallbackCaptor.value.onPostNotAvailable("posts not available.")
        verify(view).showDataError()
    }
}