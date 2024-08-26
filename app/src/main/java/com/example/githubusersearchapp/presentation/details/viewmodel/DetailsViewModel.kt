package com.example.githubusersearchapp.presentation.details.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersearchapp.data.repository.GitHubUserRepository
import com.example.githubusersearchapp.presentation.details.DetailsState

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
class DetailsViewModel(
    private val repository: GitHubUserRepository,
    private val userId: String
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsState(isLoading = true))
    val state: StateFlow<DetailsState> = _state

    init {
        fetchUserDetails()
    }

    private fun fetchUserDetails() {
        viewModelScope.launch {
            try {
                val response = repository.getUserDetails(userId)
                if (response.isSuccessful) {
                    _state.value = DetailsState(userDetails = response.body(), isLoading = false)
                } else {
                    _state.value = DetailsState(
                        errorMessage = "Error fetching details: ${response.message()}",
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.value = DetailsState(
                    errorMessage = "Exception: ${e.message}",
                    isLoading = false
                )
            }
        }
    }
}