package com.example.cathomework.di

import android.content.Context
import com.example.cathomework.di.view_model.ViewModelModule
import com.example.cathomework.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, CatsModule::class, DataModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}