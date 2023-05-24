package com.example.daggernewsetup.di.main

import com.example.daggernewsetup.ui.main.posts.PostFragment
import com.example.daggernewsetup.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class  MainFragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ProfileViewModelsModule::class])
    abstract fun contributeProfileFragment():ProfileFragment

    @ContributesAndroidInjector(modules = [PostsViewModelsModule::class])
    abstract fun contributePostFragment(): PostFragment


}