package com.example.githubusersearchapp.data.remote

import com.example.githubusersearchapp.data.model.UserResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun searchUsers(query: String, page: Int): Response<UserResponse>
}