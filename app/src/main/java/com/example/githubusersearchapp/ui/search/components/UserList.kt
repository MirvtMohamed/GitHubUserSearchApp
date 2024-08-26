package com.example.githubusersearchapp.ui.search.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.githubusersearchapp.data.model.Item

@Composable
fun UserList(users: List<Item>) {
    LazyColumn {
        items(users) { user ->
            UserListItem(user = user)
        }
    }
}
