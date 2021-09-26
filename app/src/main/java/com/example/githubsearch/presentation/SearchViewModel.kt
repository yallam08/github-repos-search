package com.example.githubsearch.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.domain.SearchGitHubReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchGitHubReposUseCase: SearchGitHubReposUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> get() = _viewState

    private var searchJob: Job = Job()

    private val exceptionHandler by lazy {
        CoroutineExceptionHandler { _, throwable ->
            handleApiException(throwable)
        }
    }

    fun onSearchQueryUpdated(query: String) {
        searchJob.cancel()

        if (query.isBlank()) {
            setNotSearchingState()
        } else {
            searchForRepo(query)
        }
    }

    private fun setNotSearchingState() {
        _viewState.value = ViewState.NotSearching
    }

    private fun searchForRepo(query: String) {
        searchJob = viewModelScope.launch(exceptionHandler) {
            _viewState.value = ViewState.Loading

            val items = searchGitHubReposUseCase.execute(query).map {
                GitHubRepoUiModel(
                    it.ownerAvatarUrl,
                    it.repoName,
                    it.repoDescription ?: "-No description-"
                )
            }

            _viewState.value = ViewState.SearchResult(items)
        }
    }

    private fun handleApiException(throwable: Throwable) {
        TODO()
    }

}

data class GitHubRepoUiModel(
    val ownerAvatarUrl: String,
    val repoName: String,
    val repoDescription: String
)

sealed class ViewState {
    object Loading : ViewState()
    object NotSearching : ViewState()
    class SearchResult(val items: List<GitHubRepoUiModel>) : ViewState()
}