package com.example.githubsearch.data.repository

import com.example.githubsearch.remote.model.GitHubSearchReposResponse

interface GitHubSearchRepo {

    suspend fun searchRepos(query: String): GitHubSearchReposResponse
}