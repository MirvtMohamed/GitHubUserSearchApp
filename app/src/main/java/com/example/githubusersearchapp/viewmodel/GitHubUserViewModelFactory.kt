package com.example.githubusersearchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubusersearchapp.data.repository.GitHubUserRepository

class GitHubUserViewModelFactory(private val repository: GitHubUserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GitHubUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GitHubUserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
