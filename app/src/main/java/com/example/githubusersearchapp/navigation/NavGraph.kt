package com.example.githubusersearchapp.navigation



import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.githubusersearchapp.data.repository.GitHubUserRepository
import com.example.githubusersearchapp.presentation.details.DetailsScreen
import com.example.githubusersearchapp.presentation.details.viewmodel.DetailsViewModel
import com.example.githubusersearchapp.presentation.details.viewmodel.DetailsViewModelFactory
import com.example.githubusersearchapp.presentation.search.SearchScreen
import com.example.githubusersearchapp.presentation.search.viewmodel.SearchViewModel


