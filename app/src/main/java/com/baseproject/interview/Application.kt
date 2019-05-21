package com.baseproject.interview

import android.app.Application
import com.baseproject.interview.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(applicationModule)
        }
    }
}