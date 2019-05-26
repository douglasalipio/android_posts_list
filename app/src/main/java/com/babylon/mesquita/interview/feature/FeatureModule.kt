package com.babylon.mesquita.interview.feature

import com.babylon.mesquita.interview.di.ActivityScoped
import dagger.Binds
import dagger.Module

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