package com.example.githubusersearchapp.navigation

object NavigationRoutes {
    const val SEARCH = "search"
    const val DETAILS = "details/{userId}"
    fun detailsRoute(userId: String) = "details/$userId"
}
