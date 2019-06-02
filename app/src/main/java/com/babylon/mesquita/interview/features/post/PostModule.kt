package com.babylon.mesquita.interview.features.post

import com.babylon.mesquita.interview.di.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class PostModule {
    //@FragmentScoped
    //@ContributesAndroidInjector
    //internal abstract fun tasksFragment(): TasksFragment
    @ActivityScoped
    @Binds
    internal abstract fun providePostPresenter(presenter: PostPresenter): PostContract.Presenter

    @ActivityScoped
    @Binds
    internal abstract fun providePostInteractor(interactor: PostInteractor): PostContract.Interactor
}