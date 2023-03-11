package com.example.sunlight.di

import com.example.sunlight.data.repo.MainRepoImpl
import com.example.sunlight.data.repo.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRepo() : MainRepository {
        return MainRepoImpl()
    }
}