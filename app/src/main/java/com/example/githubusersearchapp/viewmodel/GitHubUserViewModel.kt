package com.example.githubusersearchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersearchapp.data.model.UserResponse
import com.example.githubusersearchapp.data.repository.GitHubUserRepository
import com.example.githubusersearchapp.ui.search.SearchEvent
import com.example.githubusersearchapp.ui.search.SearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response



class GitHubUserViewModel(private val repository: GitHubUserRepository) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnQueryChanged -> {
                _state.value = _state.value.copy(query = event.query)
            }
            is SearchEvent.OnSearch -> {
                searchUsers()
            }
        }
    }

    private fun searchUsers() {
        if (_state.value.query.isBlank()) return  // Don't search for empty queries

        _state.value = _state.value.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            try {
                val response = repository.searchUsers(_state.value.query, 1)
                if (response.isSuccessful) {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        searchResults = response.body()?.items,
                        errorMessage = null
                    )
                } else {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = "Error: ${response.message()}"
                    )
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = "Error: ${e.message}"
                )
            }
        }
    }
}

/*package com.example.githubusersearchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersearchapp.data.model.UserResponse
import com.example.githubusersearchapp.data.repository.GitHubUserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class GitHubUserViewModel(private val repository: GitHubUserRepository) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _userSearchResult = MutableStateFlow<Response<UserResponse>?>(null)
    val userSearchResult: StateFlow<Response<UserResponse>?> = _userSearchResult.asStateFlow()

    fun searchUsers(query: String, page: Int) {
        if (query.isBlank()) return  // Don't search for empty queries
        _isLoading.value = true
        viewModelScope.launch {
            val response = repository.searchUsers(query, page)
            _userSearchResult.value = response
            _isLoading.value = false
        }
    }
}

***/