package com.example.daggernewsetup.di.auth

import com.example.daggernewsetup.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {
    companion object{
        @Provides
        @JvmStatic
        @AuthScope
        fun provideAuthApi(retrofit: Retrofit):AuthApi{
            return retrofit.create(AuthApi::class.java)
        }
    }
}