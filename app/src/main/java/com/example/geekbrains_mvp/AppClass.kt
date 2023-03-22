package com.example.geekbrains_mvp

import android.app.Application
import com.example.geekbrains_mvp.start.di.AppComponent
import com.example.geekbrains_mvp.start.di.DaggerAppComponent

class AppClass : Application() {

    companion object {
        lateinit var instance: AppClass
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupDagger()
    }

    private fun setupDagger() {
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }
}