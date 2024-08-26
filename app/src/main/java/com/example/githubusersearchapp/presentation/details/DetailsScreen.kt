package com.example.githubusersearchapp.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.githubusersearchapp.presentation.details.viewmodel.DetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, viewModel: DetailsViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "User Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val state by viewModel.state.collectAsState()
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                state.errorMessage != null -> {
                    Text(
                        text = state.errorMessage ?: "Unknown error",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                state.userDetails != null -> {
                    val user = state.userDetails!!

                    // User Avatar
                    Image(
                        painter = rememberAsyncImagePainter(model = user.avatar_url),
                        contentDescription = "User Avatar",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // User Details
                    UserDetailItem(
                        icon = Icons.Filled.Person,
                        label = "Username",
                        value = user.login
                    )
                    UserDetailItem(
                        icon = Icons.Filled.Star,
                        label = "Name",
                        value = user.name ?: "N/A"
                    )
                    UserDetailItem(
                        icon = Icons.Filled.Info,
                        label = "Bio",
                        value = user.bio ?: "N/A"
                    )
                    UserDetailItem(
                        icon = Icons.Filled.LocationOn,
                        label = "Location",
                        value = user.location ?: "N/A"
                    )
                    UserDetailItem(
                        icon = Icons.Filled.Share,
                        label = "Public Repos",
                        value = user.public_repos?.toString() ?: "N/A"
                    )
                    UserDetailItem(
                        icon = Icons.Filled.Person,
                        label = "Followers",
                        value = user.followers?.toString() ?: "N/A"
                    )
                    UserDetailItem(
                        icon = Icons.Filled.Person,
                        label = "Following",
                        value = user.following?.toString() ?: "N/A"
                    )
                }
            }
        }
    }
}

@Composable
fun UserDetailItem(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}
