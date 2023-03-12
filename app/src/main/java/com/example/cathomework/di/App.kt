package com.example.cathomework.di

import android.app.Application
import com.example.cathomework.di.ApplicationComponent
import com.example.cathomework.di.DaggerApplicationComponent

class App : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}