package com.example.githubsearch.di

import com.example.githubsearch.data.cache_data_source.CacheDataSource
import com.example.githubsearch.data.remote_data_source.RemoteDataSource
import com.example.githubsearch.domain.GitHubSearchRepo
import com.example.githubsearch.data.repository.GitHubSearchRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideGitHubSearchRepo(
        cacheDataSource: CacheDataSource,
        remoteDataSource: RemoteDataSource
    ): GitHubSearchRepo {
        return GitHubSearchRepoImpl(cacheDataSource, remoteDataSource)
    }

}