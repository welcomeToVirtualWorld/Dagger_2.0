package com.example.daggernewsetup.di.main

import androidx.lifecycle.ViewModelProvider
import com.example.daggernewsetup.di.qualifier.MainInfo
import com.example.daggernewsetup.sessionmanager.SessionStoreManager
import com.example.daggernewsetup.ui.main.MainViewModel
import com.example.daggernewsetup.ui.main.profile.ProfileViewModel
import com.example.daggernewsetup.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainViewModelsModule {


    @Provides
    @MainInfo
    fun mainViewModelProvider(mainViewModel: MainViewModel):ViewModelProvider.Factory{
        return ViewModelFactory(mainViewModel)
    }

    @Provides
    fun provideMainViewModel(sessionStoreManager: SessionStoreManager):MainViewModel{
        return MainViewModel(sessionStoreManager)
    }

}