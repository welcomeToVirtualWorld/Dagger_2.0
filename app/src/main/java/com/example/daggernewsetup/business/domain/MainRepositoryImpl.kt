package com.example.daggernewsetup.business.domain

import com.example.daggernewsetup.model.Posts
import com.example.daggernewsetup.network.DThrowable
import com.example.daggernewsetup.network.Resource
import com.example.daggernewsetup.network.main.MainApi
import com.example.daggernewsetup.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainApi: MainApi
):MainRepository {


    override fun getPosts(): Flow<Resource<List<Posts>>> {
        return flow {
            emit(Resource.Loading())
            val result = mainApi.getAllPosts(2)
            if (result.isSuccessful && result.body()!=null){
                emit(Resource.Success(result.body()))
            }else{
                emit(Resource.Error(DThrowable(result.code(),result.message())))
            }
        }

    }
}