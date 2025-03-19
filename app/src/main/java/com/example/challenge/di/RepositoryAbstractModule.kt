package com.example.challenge.di

import com.example.challenge.data.repository.log_in.LogInRepositoryImpl
import com.example.challenge.domain.repository.log_in.LogInRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryAbstractModule {
    @Binds
    @Singleton
    abstract fun bindLoginRepository(
        impl: LogInRepositoryImpl
    ): LogInRepository
}