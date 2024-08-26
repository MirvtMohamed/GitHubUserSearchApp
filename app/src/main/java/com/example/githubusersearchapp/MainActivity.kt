package com.example.githubusersearchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubusersearchapp.data.remote.ApiClient
import com.example.githubusersearchapp.data.repository.GitHubUserRepositoryImpl
import com.example.githubusersearchapp.ui.search.SearchScreen
import com.example.githubusersearchapp.viewmodel.GitHubUserViewModel
import com.example.githubusersearchapp.viewmodel.GitHubUserViewModelFactory

class MainActivity : ComponentActivity() {

    // Create the ViewModel using the factory
    private val viewModel: GitHubUserViewModel by viewModels {
        GitHubUserViewModelFactory(GitHubUserRepositoryImpl(ApiClient))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchScreen(viewModel = viewModel)

        }
    }
}

