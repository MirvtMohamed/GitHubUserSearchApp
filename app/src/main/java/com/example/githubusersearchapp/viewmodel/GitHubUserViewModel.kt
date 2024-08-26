package com.example.githubusersearchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersearchapp.data.model.UserResponse
import com.example.githubusersearchapp.data.repository.GitHubUserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class GitHubUserViewModel(private val repository: GitHubUserRepository) : ViewModel() {

    // StateFlow to hold the search results
    private val _userSearchResult = MutableStateFlow<Response<UserResponse>?>(null)
    val userSearchResult: StateFlow<Response<UserResponse>?> get() = _userSearchResult

    // Function to perform the search
    fun searchUsers(query: String, page: Int) {
        viewModelScope.launch {
            try {
                val response = repository.searchUsers(query, page)
                _userSearchResult.value = response
            } catch (e: Exception) {
                // Handle error and update StateFlow with null or an error state if needed
                _userSearchResult.value = null
            }
        }
    }
}
