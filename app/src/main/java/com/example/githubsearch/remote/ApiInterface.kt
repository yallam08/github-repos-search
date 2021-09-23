package com.example.githubsearch.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search/repositories?q=:query")
    suspend fun searchGitHubRepos(@Query("q") searchQuery: String)
}