package com.example.githubusersearchapp.presentation.search

import com.example.githubusersearchapp.data.model.Item

data class SearchState(
    val query: String = "",
    val isLoading: Boolean = false,
    val searchResults: List<Item>? = null,
    val errorMessage: String? = null
)

