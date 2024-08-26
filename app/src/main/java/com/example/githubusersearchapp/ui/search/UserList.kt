package com.example.githubusersearchapp.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.githubusersearchapp.data.model.Item

@Composable
fun UserList(users: List<Item>) {
    LazyColumn {
        items(users) { user ->
            UserListItem(user = user)
        }
    }
}
