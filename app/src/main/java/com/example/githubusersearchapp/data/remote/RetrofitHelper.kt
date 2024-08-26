package com.example.githubusersearchapp.data.remote


import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    private val gson = GsonBuilder().serializeNulls().create()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}