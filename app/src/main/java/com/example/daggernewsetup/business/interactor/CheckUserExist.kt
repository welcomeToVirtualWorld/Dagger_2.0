package com.example.daggernewsetup.business.interactor

import com.example.daggernewsetup.model.UserItem
import com.example.daggernewsetup.network.Resource
import com.example.daggernewsetup.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CheckUserExist @Inject constructor(
    val authRepository: AuthRepository
){

    operator fun invoke(id:Int):Flow<Resource<UserItem>>{
        return authRepository.getFakeStuff(id)
    }

}