package com.example.githubsearch.domain

import com.example.githubsearch.domain.model.GitHubRepoDomainModel

interface GitHubSearchRepo {

    suspend fun searchRepos(query: String): List<GitHubRepoDomainModel>
}