package com.example.githubsearch.remote

import com.example.githubsearch.remote.model.GitHubSearchReposResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search/repositories")
    suspend fun searchGitHubRepos(@Query("q") searchQuery: String): GitHubSearchReposResponse
}