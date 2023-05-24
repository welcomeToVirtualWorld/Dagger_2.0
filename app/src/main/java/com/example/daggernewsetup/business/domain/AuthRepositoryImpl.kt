package com.example.daggernewsetup.business.domain

import com.example.daggernewsetup.model.UserItem
import com.example.daggernewsetup.network.DThrowable
import com.example.daggernewsetup.network.Resource
import com.example.daggernewsetup.network.auth.AuthApi
import com.example.daggernewsetup.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
):AuthRepository {


    override fun getFakeStuff(id:Int): Flow<Resource<UserItem>> {
        return flow {
            emit(Resource.Loading())
            val result = authApi.getFakeStuff(id)
            if (result.isSuccessful && result.body()!=null){
                emit(Resource.Success(result.body()))
            }else{
                emit(Resource.Error(DThrowable(result.code(),result.message())))
            }
        }

    }


}