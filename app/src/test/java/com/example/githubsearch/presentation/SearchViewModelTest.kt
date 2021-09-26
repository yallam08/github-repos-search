package com.example.githubsearch.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubsearch.domain.SearchGitHubReposUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var searchGitHubReposUseCase: SearchGitHubReposUseCase

    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)

        viewModel = SearchViewModel(searchGitHubReposUseCase)
    }

    @Test
    fun searchPerformed_whenSearchQueryUpdated_withNonEmptyValue() = runBlockingTest {
        whenever(searchGitHubReposUseCase.execute(any())).thenReturn(emptyList())

        viewModel.onSearchQueryUpdated("test")
        assertThat(viewModel.viewState.value).isInstanceOf(ViewState.SearchResult::class.java)
    }

    @Test
    fun viewStateIsError_whenSearchFails() = runBlockingTest {
        whenever(searchGitHubReposUseCase.execute(any())).thenThrow(RuntimeException())

        viewModel.onSearchQueryUpdated("test")
        assertThat(viewModel.viewState.value).isInstanceOf(ViewState.Error::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}