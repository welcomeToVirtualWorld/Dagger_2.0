package com.example.daggernewsetup.network.main

import com.example.daggernewsetup.model.Posts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    suspend fun getAllPosts(
        @Query("userId") id:Int
    ):Response<List<Posts>>

}