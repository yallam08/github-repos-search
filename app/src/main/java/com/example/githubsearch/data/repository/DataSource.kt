package com.example.githubsearch.data.repository

interface DataSource {

    fun searchRepos(query: String)
}