package com.example.githubsearch.data.remote_data_source

import com.example.githubsearch.data.repository.DataSource
import com.example.githubsearch.remote.ApiInterface
import com.example.githubsearch.remote.model.GitHubSearchReposResponse
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiInterface: ApiInterface) : DataSource {

    override suspend fun searchRepos(query: String): GitHubSearchReposResponse {
        return apiInterface.searchGitHubRepos(query)
    }
}