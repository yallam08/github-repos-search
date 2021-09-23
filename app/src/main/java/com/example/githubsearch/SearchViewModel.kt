package com.example.githubsearch

import androidx.lifecycle.ViewModel
import com.example.githubsearch.data.repository.GitHubSearchRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepo: GitHubSearchRepo
) : ViewModel() {
}