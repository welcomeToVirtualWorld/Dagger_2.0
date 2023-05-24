package com.example.daggernewsetup.di

import com.example.daggernewsetup.di.auth.AuthModule
import com.example.daggernewsetup.di.auth.AuthRepositoryModule
import com.example.daggernewsetup.di.auth.AuthScope
import com.example.daggernewsetup.di.auth.AuthViewModelsModule
import com.example.daggernewsetup.di.main.*
import com.example.daggernewsetup.ui.auth.AuthActivity
import com.example.daggernewsetup.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class, AuthModule::class,AuthRepositoryModule::class]
    )
    @AuthScope
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [MainViewModelsModule::class,MainFragmentBuilderModule::class,MainModule::class,MainRepositoryModule::class]
    )
    @MainScope
    abstract fun contributeMainActivity(): MainActivity

}