package com.example.daggernewsetup.business.interactor

import com.example.daggernewsetup.model.Posts
import com.example.daggernewsetup.network.Resource
import com.example.daggernewsetup.repository.AuthRepository
import com.example.daggernewsetup.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPosts @Inject constructor(
    val mainRepository: MainRepository
) {

    operator fun invoke():Flow<Resource<List<Posts>>>{
        return mainRepository.getPosts()
    }
}