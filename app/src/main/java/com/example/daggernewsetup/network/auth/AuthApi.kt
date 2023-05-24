package com.example.daggernewsetup.network.auth

import com.example.daggernewsetup.model.UserItem
import com.example.daggernewsetup.network.Resource
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{id}")
    suspend fun getFakeStuff(
        @Path("id") id:Int
    ):Response<UserItem>
}