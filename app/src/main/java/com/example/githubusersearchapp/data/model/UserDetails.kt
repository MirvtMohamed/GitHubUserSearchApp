package com.example.githubusersearchapp.data.model



data class UserDetails(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String?,
    val bio: String?,
    val location: String?,
    val public_repos: Int?,
    val followers: Int?,
    val following: Int?

)
