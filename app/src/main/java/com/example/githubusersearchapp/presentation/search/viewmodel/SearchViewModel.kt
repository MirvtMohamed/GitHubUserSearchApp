package com.example.githubusersearchapp.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersearchapp.data.repository.GitHubUserRepository
import com.example.githubusersearchapp.presentation.search.SearchEvent
import com.example.githubusersearchapp.presentation.search.SearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SearchViewModel(private val repository: GitHubUserRepository) : ViewModel() {

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
            //navigation

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
