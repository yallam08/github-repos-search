package com.example.githubsearch.presentation.repos_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearch.databinding.ListItemSearchReposBinding
import com.example.githubsearch.presentation.GitHubRepoUiModel
import com.example.githubsearch.utils.loadImageFromUrl

open class ReposListAdapter() : RecyclerView.Adapter<ReposListAdapter.RepoViewHolder>() {

    private var list = listOf<GitHubRepoUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RepoViewHolder {
        val binding = ListItemSearchReposBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return RepoViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(list[position])
    }


    fun setItems(items: List<GitHubRepoUiModel>) {
        list = items
        notifyDataSetChanged()
    }

    class RepoViewHolder(private val binding: ListItemSearchReposBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GitHubRepoUiModel) {
            binding.ivOwnerAvatar.loadImageFromUrl(item.ownerAvatarUrl)
            binding.tvRepoName.text = item.repoName
            binding.tvRepoDescription.text = item.repoDescription
        }
    }
}
