package com.babylon.mesquita.interview

import androidx.room.Room
import com.babylon.mesquita.interview.data.local.AppDatabase
import com.babylon.mesquita.interview.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        //initDatabase()
    }

    private fun initDatabase() {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app_db")
            .build()
    }
}