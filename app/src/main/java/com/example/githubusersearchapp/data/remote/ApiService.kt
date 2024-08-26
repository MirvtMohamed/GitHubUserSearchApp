package com.example.githubusersearchapp.data.remote

import com.example.githubusersearchapp.data.model.UserDetails
import com.example.githubusersearchapp.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int
    ): Response<UserResponse>

    @GET("users/{userId}")
    suspend fun getUserDetails(
        @Path("userId") userId: String
    ): Response<UserDetails>
}