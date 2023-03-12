package com.example.cathomework.di

import com.example.cathomework.data.RepositoryImpl
import com.example.cathomework.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun getCat(impl: RepositoryImpl): Repository
}