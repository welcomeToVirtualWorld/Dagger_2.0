package com.example.daggernewsetup.di.main

import androidx.lifecycle.ViewModelProvider
import com.example.daggernewsetup.di.qualifier.ProfileFragmentInfo
import com.example.daggernewsetup.ui.main.profile.ProfileViewModel
import com.example.daggernewsetup.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ProfileViewModelsModule {

    @Provides
    @ProfileFragmentInfo
    fun profileViewModelProvider(profileViewModel: ProfileViewModel): ViewModelProvider.Factory{
        return ViewModelFactory(profileViewModel)
    }

    @Provides
    fun provideProfileViewModel(): ProfileViewModel {
        return ProfileViewModel()
    }
}