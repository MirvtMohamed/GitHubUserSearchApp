package com.example.githubusersearchapp.data.model

data class UserResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)