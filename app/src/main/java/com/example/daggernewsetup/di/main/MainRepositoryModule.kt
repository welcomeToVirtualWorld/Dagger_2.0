package com.example.daggernewsetup.di.main

import com.example.daggernewsetup.business.domain.AuthRepositoryImpl
import com.example.daggernewsetup.business.domain.MainRepositoryImpl
import com.example.daggernewsetup.repository.AuthRepository
import com.example.daggernewsetup.repository.MainRepository
import dagger.Module
import dagger.Provides

@Module
class MainRepositoryModule {

    @Provides
    @MainScope
    fun provideMainRepository(mainRepositoryImpl: MainRepositoryImpl):MainRepository{
        return mainRepositoryImpl
    }
}