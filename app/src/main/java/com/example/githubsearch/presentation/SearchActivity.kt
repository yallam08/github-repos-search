package com.example.githubsearch.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearch.R
import com.example.githubsearch.databinding.ActivitySearchBinding
import com.example.githubsearch.presentation.repos_list.ReposListAdapter
import com.example.githubsearch.utils.textChanges
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: ActivitySearchBinding
    private val reposListAdapter = ReposListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        observeViewModel()
    }

    private fun initUi() {
        binding.toolbar.title = getString(R.string.app_name)

        initSearchField()
        initRecyclerView()
    }

    private fun initSearchField() {
        binding.etSearch
            .textChanges()
            .filterNot { it.isNullOrBlank() }
            .debounce(400)
            .onEach {
                viewModel.onSearchQueryUpdated(it.toString())
            }
            .launchIn(lifecycleScope)
    }

    private fun initRecyclerView() {
        binding.rvRepos.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = reposListAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@SearchActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun observeViewModel() {
        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.rvRepos.isVisible = false
                    binding.tvNoResultsFound.isVisible = false
                }
                is ViewState.SearchResult -> {
                    binding.progressBar.isVisible = false
                    binding.rvRepos.isVisible = state.items.isNotEmpty()
                    binding.tvNoResultsFound.isVisible = state.items.isEmpty()

                    reposListAdapter.setItems(state.items)
                }

                is ViewState.NotSearching -> {
                    binding.progressBar.isVisible = false
                    binding.rvRepos.isVisible = false
                    binding.tvNoResultsFound.isVisible = false

                    reposListAdapter.setItems(emptyList())
                }

                is ViewState.Error -> {
                    binding.progressBar.isVisible = false
                    binding.tvNoResultsFound.isVisible = false

                    Snackbar.make(binding.root, "An error occurred!", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

}