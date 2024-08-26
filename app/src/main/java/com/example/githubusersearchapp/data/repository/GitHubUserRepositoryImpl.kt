package com.example.githubusersearchapp.data.repository

import com.example.githubusersearchapp.data.model.UserDetails
import com.example.githubusersearchapp.data.model.UserResponse
import com.example.githubusersearchapp.data.remote.RemoteDataSource
import retrofit2.Response

class GitHubUserRepositoryImpl(private val remoteDataSource: RemoteDataSource) : GitHubUserRepository {
    override suspend fun searchUsers(query: String, page: Int): Response<UserResponse> {
        return remoteDataSource.searchUsers(query, page)
    }

    override suspend fun getUserDetails(userId: String): Response<UserDetails> {
        return remoteDataSource.getUserDetails(userId) // Implement this method in your RemoteDataSource
    }
}
