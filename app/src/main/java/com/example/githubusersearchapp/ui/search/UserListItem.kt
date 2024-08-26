package com.example.githubusersearchapp.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.githubusersearchapp.data.model.Item

@Composable
fun UserListItem(user: Item) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = user.avatar_url),
            contentDescription = "User Avatar",
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = user.login)
            Text(text = "ID: ${user.id}")
        }
    }
}
