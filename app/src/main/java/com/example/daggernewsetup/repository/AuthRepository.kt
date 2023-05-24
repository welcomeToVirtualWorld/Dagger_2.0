package com.example.daggernewsetup.repository

import com.example.daggernewsetup.model.UserItem
import com.example.daggernewsetup.network.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun getFakeStuff(id:Int):Flow<Resource<UserItem>>
}