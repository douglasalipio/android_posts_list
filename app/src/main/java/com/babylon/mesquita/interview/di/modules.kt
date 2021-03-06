package com.babylon.mesquita.interview.di

import android.app.Application
import android.content.Context
import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.AppRepository
import com.babylon.mesquita.interview.data.remote.ApiHelper
import com.babylon.mesquita.interview.data.remote.RemoteDataSource
import com.babylon.mesquita.interview.data.remote.ServiceAppFactory
import com.babylon.mesquita.interview.features.post.PostActivity
import com.babylon.mesquita.interview.features.post.PostModule
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun postAcitivity(): PostActivity
}

@Module
class AppModule {
    @Provides
    @Reusable
    internal fun provideContext(application: Application): Context = application
}

@Module
class RepositoryModule {
    @Provides
    @Reusable
    internal fun provideAppRepository(remoteDataSource: RemoteDataSource): AppDataSource =
        AppRepository(remoteDataSource)
}

@Module
class NetworkModule {
    @Provides
    @Reusable
    internal fun provideRemoteRepository(apiHelper: ApiHelper): RemoteDataSource = RemoteDataSource(apiHelper)

    @Provides
    @Reusable
    internal fun providePostApi() = ServiceAppFactory.create(true)
}
