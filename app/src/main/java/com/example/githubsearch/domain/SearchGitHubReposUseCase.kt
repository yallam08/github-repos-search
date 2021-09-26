package com.example.githubsearch.domain

import com.example.githubsearch.data.repository.GitHubSearchRepo
import com.example.githubsearch.domain.model.GitHubRepoDomainModel
import javax.inject.Inject

class SearchGitHubReposUseCase @Inject constructor(
    private val searchRepo: GitHubSearchRepo
) {

    suspend fun execute(query: String): List<GitHubRepoDomainModel> {
        return searchRepo.searchRepos(query).items.map {
            GitHubRepoDomainModel(
                it.owner.avatarUrl,
                it.name,
                it.description
            )
        }
    }
}