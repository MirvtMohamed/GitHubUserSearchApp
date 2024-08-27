package com.example.githubusersearchapp.navigation



import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.githubusersearchapp.data.remote.ApiClient
import com.example.githubusersearchapp.data.repository.GitHubUserRepository
import com.example.githubusersearchapp.data.repository.GitHubUserRepositoryImpl
import com.example.githubusersearchapp.presentation.details.DetailsScreen
import com.example.githubusersearchapp.presentation.details.viewmodel.DetailsViewModel
import com.example.githubusersearchapp.presentation.details.viewmodel.DetailsViewModelFactory
import com.example.githubusersearchapp.presentation.search.SearchScreen
import com.example.githubusersearchapp.presentation.search.viewmodel.SearchViewModel



@Composable
fun NavGraph(
    navController: NavHostController,
    searchViewModel: SearchViewModel
) {
    NavHost(navController = navController, startDestination = NavigationRoutes.SEARCH) {
        composable(NavigationRoutes.SEARCH) {
            SearchScreen(
                viewModel = searchViewModel,
                onUserClick = { userId ->
                    navController.navigate(NavigationRoutes.detailsRoute(userId))
                }
            )
        }
        composable(NavigationRoutes.DETAILS) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            if (userId == null) {
                Log.e("NavGraph", "User ID is null")
                navController.popBackStack() // Navigate back if userId is null
                return@composable
            }
            val detailsViewModel: DetailsViewModel = viewModel(factory = createDetailsViewModelFactory(userId))
            DetailsScreen(navController = navController, viewModel = detailsViewModel)
        }
    }
}

private fun createDetailsViewModelFactory(userId: String): DetailsViewModelFactory {
    return DetailsViewModelFactory(GitHubUserRepositoryImpl(ApiClient), userId)
}
