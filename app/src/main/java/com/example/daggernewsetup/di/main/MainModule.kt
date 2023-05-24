package com.example.daggernewsetup.di.main

import com.example.daggernewsetup.network.auth.AuthApi
import com.example.daggernewsetup.network.main.MainApi
import com.example.daggernewsetup.ui.main.posts.CustomAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {
    companion object{
        @Provides
        @JvmStatic
        @MainScope
        fun provideMainApi(retrofit: Retrofit): MainApi {
            return retrofit.create(MainApi::class.java)
        }

        @Provides
        @JvmStatic
        @MainScope
        fun provideAdapter():CustomAdapter{
            return CustomAdapter()
        }
    }
}