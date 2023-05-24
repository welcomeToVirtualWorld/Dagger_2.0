package com.example.daggernewsetup.repository

import com.example.daggernewsetup.model.Posts
import com.example.daggernewsetup.network.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getPosts(): Flow<Resource<List<Posts>>>
}