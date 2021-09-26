package com.example.githubsearch.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearch.R
import com.example.githubsearch.databinding.ActivitySearchBinding
import com.example.githubsearch.presentation.repos_list.ReposListAdapter
import dagger.hilt.android.AndroidEntryPoint

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

        viewModel.searchForRepo("movie") // TODO: remove this
    }

    private fun initUi() {
        binding.toolbar.title = getString(R.string.app_name)

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
                }
                is ViewState.Ready -> {
                    binding.progressBar.isVisible = false
                    binding.rvRepos.isVisible = true

                    reposListAdapter.setItems(state.items)
                }
            }
        }
    }


}