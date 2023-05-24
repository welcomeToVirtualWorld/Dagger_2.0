package com.example.daggernewsetup.di.auth

import com.example.daggernewsetup.business.domain.AuthRepositoryImpl
import com.example.daggernewsetup.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class AuthRepositoryModule {



    @Provides
    @AuthScope
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl):AuthRepository{
        return authRepositoryImpl
    }

//    @Binds
//    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}