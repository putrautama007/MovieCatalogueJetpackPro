package com.b.moviecataloguemvvm.utils

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class DiskIOThreadExecutor : Executor {

    private val diskIO: Executor
    init {
        diskIO = Executors.newSingleThreadExecutor()
    }
    override fun execute(p0: Runnable) {
        diskIO.execute(p0)
    }
}