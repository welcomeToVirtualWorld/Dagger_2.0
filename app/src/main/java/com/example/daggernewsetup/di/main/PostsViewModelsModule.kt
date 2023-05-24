package com.example.daggernewsetup.di.main

import androidx.lifecycle.ViewModelProvider
import com.example.daggernewsetup.business.interactor.GetAllPosts
import com.example.daggernewsetup.di.qualifier.PostFragmentInfo
import com.example.daggernewsetup.network.main.MainApi
import com.example.daggernewsetup.sessionmanager.SessionStoreManager
import com.example.daggernewsetup.ui.main.posts.PostViewModel
import com.example.daggernewsetup.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class PostsViewModelsModule {

    @Provides
    @PostFragmentInfo
    fun provideViewModelFactory(viewModel: PostViewModel): ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }

    @Provides
    fun providePostViewModel(mainApi: MainApi,sessionStoreManager: SessionStoreManager,getAllPosts: GetAllPosts):PostViewModel{
        return PostViewModel(mainApi,sessionStoreManager,getAllPosts)
    }
}