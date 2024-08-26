package com.example.githubusersearchapp.data.repository

import com.example.githubusersearchapp.data.model.UserDetails
import com.example.githubusersearchapp.data.model.UserResponse
import retrofit2.Response

interface GitHubUserRepository {
    suspend fun searchUsers(query: String, page: Int): Response<UserResponse>
    suspend fun getUserDetails(userId: String): Response<UserDetails>
}
