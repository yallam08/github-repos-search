package com.example.githubsearch.data.repository

import com.example.githubsearch.remote.model.GitHubSearchReposResponse

interface DataSource {

    suspend fun searchRepos(query: String): GitHubSearchReposResponse
}