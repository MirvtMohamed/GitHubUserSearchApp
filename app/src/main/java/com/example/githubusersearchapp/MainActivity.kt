package com.example.githubusersearchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubusersearchapp.data.remote.ApiClient
import com.example.githubusersearchapp.data.repository.GitHubUserRepositoryImpl
import com.example.githubusersearchapp.presentation.details.DetailsScreen
import com.example.githubusersearchapp.presentation.search.SearchScreen
import com.example.githubusersearchapp.presentation.search.viewmodel.SearchViewModel
import com.example.githubusersearchapp.presentation.search.viewmodel.SearchViewModelFactory

class MainActivity : ComponentActivity() {


    private val viewModel: SearchViewModel by viewModels {
        SearchViewModelFactory(GitHubUserRepositoryImpl(ApiClient))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchScreen(viewModel = viewModel)

        }
    }
}

