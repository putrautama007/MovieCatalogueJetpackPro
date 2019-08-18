package com.b.moviecataloguemvvm.utils


import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors

open class AppExecutors @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor) {

    constructor() : this(
        DiskIOThreadExecutor(),Executors.newFixedThreadPool(THREAD_COUNT),
        MainThreadExecutor()
    )

    fun diskIO() : Executor{
        return  diskIO
    }

    fun networkIO() : Executor{
        return networkIO
    }

    fun mainThread(): Executor{
        return mainThread
    }

    private class MainThreadExecutor: Executor{
        private val threadHandler = Handler(Looper.getMainLooper())

        override fun execute(p0: Runnable) {
            threadHandler.post(p0)
        }
    }


    companion object {

        private const val THREAD_COUNT = 3
    }
}