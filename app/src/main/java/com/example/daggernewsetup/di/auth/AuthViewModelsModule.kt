package com.example.daggernewsetup.di.auth

import androidx.lifecycle.ViewModelProvider
import com.example.daggernewsetup.business.interactor.CheckUserExist
import com.example.daggernewsetup.network.auth.AuthApi
import com.example.daggernewsetup.sessionmanager.SessionStoreManager
import com.example.daggernewsetup.ui.auth.AuthViewModel
import com.example.daggernewsetup.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AuthViewModelsModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(AuthViewModel::class)
//    internal abstract fun postListViewModel(viewModel: AuthViewModel): ViewModel

    @Provides
    fun authViewModelProvider(authViewModel: AuthViewModel):ViewModelProvider.Factory{
        return ViewModelFactory(authViewModel)
    }

    @Provides
    fun provideAuthViewModel(authApi:AuthApi,sessionStoreManager: SessionStoreManager,checkUserExist: CheckUserExist):AuthViewModel{
        return AuthViewModel(authApi,sessionStoreManager,checkUserExist)
    }
}