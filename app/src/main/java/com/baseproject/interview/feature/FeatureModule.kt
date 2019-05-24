package com.baseproject.interview.feature

import com.baseproject.interview.di.ActivityScoped
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class FeatureModule {
    //@FragmentScoped
    //@ContributesAndroidInjector
    //internal abstract fun tasksFragment(): TasksFragment
    @ActivityScoped
    @Binds
    internal abstract fun featurePresenter(presenter: FeaturePresenter): FeatureContract.Presenter

    @ActivityScoped
    @Binds
    internal abstract fun featureInteractor(interactor: FeatureInteractor): FeatureContract.Interactor
}