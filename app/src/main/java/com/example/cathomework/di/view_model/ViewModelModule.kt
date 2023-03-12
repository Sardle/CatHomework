package com.example.cathomework.di.view_model

import androidx.lifecycle.ViewModel
import com.example.cathomework.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindLoginViewModel(viewModel: MainViewModel): ViewModel
}