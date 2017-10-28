package com.oneguygames.exarchcomponents

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Created by Jonathan Muller on 10/27/17.
 */
class App: Application() {

    companion object {
        fun context(): Context {
            return c
        }

        @SuppressLint("StaticFieldLeak")
        private lateinit var c: Context
    }

    override fun onCreate() {
        super.onCreate()
        c = applicationContext
    }

}