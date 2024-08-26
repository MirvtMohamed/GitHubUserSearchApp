package com.example.githubusersearchapp.presentation.details



import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import com.example.githubusersearchapp.presentation.details.viewmodel.DetailsViewModel

@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            state.errorMessage != null -> {
                Text(
                    text = state.errorMessage ?: "Unknown error",
                    color = MaterialTheme.colorScheme.error
                )
            }
            state.userDetails != null -> {
                val user = state.userDetails!!
                // Display user details
                Text(text = "Username: ${user.login}", style = MaterialTheme.typography.headlineLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Bio: ${user.bio}", style = MaterialTheme.typography.bodyMedium)
                // Add more details as needed
            }
        }
    }
}
