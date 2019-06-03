package com.babylon.mesquita.interview.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlin.coroutines.CoroutineContext

const val THREAD_COUNT = 3

/**
 * Global executor pools for the whole application.
 */
open class AppExecutors {
    companion object {
        val ioContext: CoroutineContext
            get() = Dispatchers.IO

        val uiContext: CoroutineContext
            get() = Dispatchers.Main
    }
}

