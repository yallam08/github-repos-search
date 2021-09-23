package com.example.githubsearch.di

import com.example.githubsearch.data.repository.GitHubSearchRepo
import com.example.githubsearch.data.repository.GitHubSearchRepoImpl
import com.example.githubsearch.remote.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGitHubSearchRepo(): GitHubSearchRepo {
        return GitHubSearchRepoImpl()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

}