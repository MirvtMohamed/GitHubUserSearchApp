package com.example.githubusersearchapp.ui.search

sealed class SearchEvent {
    data class OnQueryChanged(val query: String) : SearchEvent()
    object OnSearch : SearchEvent()
}
