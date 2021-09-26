package com.example.githubsearch.data.repository

import com.example.githubsearch.data.cache_data_source.CacheDataSource
import com.example.githubsearch.data.remote_data_source.RemoteDataSource
import com.example.githubsearch.remote.model.GitHubSearchReposResponse
import javax.inject.Inject

class GitHubSearchRepoImpl @Inject constructor(
    private val cacheDataSource: CacheDataSource,
    private val remoteDataSource: RemoteDataSource
) : GitHubSearchRepo {

    override suspend fun searchRepos(query: String): GitHubSearchReposResponse {
        return remoteDataSource.searchRepos(query)
    }
}