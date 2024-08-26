package com.example.githubusersearchapp.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubusersearchapp.viewmodel.GitHubUserViewModel

@Composable
fun SearchScreen(viewModel: GitHubUserViewModel) {
    val searchQuery = remember { mutableStateOf("") }
    val searchResults by viewModel.userSearchResult.collectAsState()
    val isLoading = searchResults == null

    Column(modifier = Modifier.padding(16.dp)) {
        SearchBar(
            query = searchQuery.value,
            onQueryChanged = { searchQuery.value = it },
            onSearch = { viewModel.searchUsers(searchQuery.value, 1) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            searchResults?.let { response ->
                if (response.isSuccessful) {
                    response.body()?.items?.let { users ->
                        UserList(users = users)
                    }
                } else {
                    Text("Error: ${response.message()}")
                }
            }
        }
    }
}
