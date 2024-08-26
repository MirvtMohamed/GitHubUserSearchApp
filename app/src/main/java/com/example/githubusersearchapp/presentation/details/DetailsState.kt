package com.example.githubusersearchapp.presentation.details



import com.example.githubusersearchapp.data.model.UserDetails


data class DetailsState(
    val isLoading: Boolean = false,
    val userDetails: UserDetails? = null,
    val errorMessage: String? = null
)