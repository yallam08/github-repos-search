package com.example.githubsearch.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.domain.SearchGitHubReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchGitHubReposUseCase: SearchGitHubReposUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> get() = _viewState

    private val exceptionHandler by lazy {
        CoroutineExceptionHandler { _, throwable ->
            handleApiException(throwable)
        }
    }

    fun searchForRepo(query: String) {
        viewModelScope.launch(exceptionHandler) {
            _viewState.value = ViewState.Loading

            val items = searchGitHubReposUseCase.execute(query).map {
                GitHubRepoUiModel(
                    it.ownerAvatarUrl,
                    it.repoName,
                    it.repoDescription ?: "No description"
                )
            }

            _viewState.value = ViewState.Ready(items)
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
    class Ready(val items: List<GitHubRepoUiModel>) : ViewState()
}