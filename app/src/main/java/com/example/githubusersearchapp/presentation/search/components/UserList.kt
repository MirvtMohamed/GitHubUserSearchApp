package com.example.githubusersearchapp.presentation.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.githubusersearchapp.data.model.Item
@Composable
fun UserList(users: List<Item>, onUserClick: (String) -> Unit) {
    LazyColumn {
        items(users) { user ->
            UserListItem(user = user, onUserClick = onUserClick)
        }
    }
}


