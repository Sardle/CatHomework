package com.example.cathomework.di

import com.example.cathomework.data.RepositoryImpl
import com.example.cathomework.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun getCat(impl: RepositoryImpl): Repository
}