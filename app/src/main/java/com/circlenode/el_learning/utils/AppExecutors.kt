package com.circlenode.el_learning.utils

import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun runOnUiThread(f: () -> Unit){
    IO_EXECUTOR.execute(f)
}