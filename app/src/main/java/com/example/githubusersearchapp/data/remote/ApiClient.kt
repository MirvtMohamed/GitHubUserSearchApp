package com.example.githubusersearchapp.data.remote

import com.example.githubusersearchapp.data.model.UserResponse
import retrofit2.Response


object ApiClient: RemoteDataSource {
    override suspend fun searchUsers(query: String, page: Int): Response<UserResponse> {
        return RetrofitHelper.retrofitService.searchUsers(query, page)
    }

}