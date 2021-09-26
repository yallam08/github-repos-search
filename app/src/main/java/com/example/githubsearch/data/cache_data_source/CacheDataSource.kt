package com.example.githubsearch.data.cache_data_source

import com.example.githubsearch.data.repository.DataSource
import com.example.githubsearch.remote.model.GitHubSearchReposResponse
import javax.inject.Inject


class CacheDataSource @Inject constructor() : DataSource {

    override suspend fun searchRepos(query: String): GitHubSearchReposResponse {
        TODO()
    }

    fun isCacheExpired(): Boolean {
        TODO()
    }
}