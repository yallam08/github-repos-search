package com.example.githubsearch.data.repository

import com.example.githubsearch.data.cache_data_source.CacheDataSource
import com.example.githubsearch.data.remote_data_source.RemoteDataSource
import com.example.githubsearch.domain.GitHubSearchRepo
import com.example.githubsearch.domain.model.GitHubRepoDomainModel
import javax.inject.Inject

class GitHubSearchRepoImpl @Inject constructor(
    private val cacheDataSource: CacheDataSource,
    private val remoteDataSource: RemoteDataSource
) : GitHubSearchRepo {

    override suspend fun searchRepos(query: String): List<GitHubRepoDomainModel> {
        return remoteDataSource.searchRepos(query).items.map {
            GitHubRepoDomainModel(
                it.owner.avatarUrl,
                it.name,
                it.description
            )
        }
    }
}