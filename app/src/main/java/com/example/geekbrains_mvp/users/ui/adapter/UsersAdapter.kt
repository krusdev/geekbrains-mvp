package com.example.geekbrains_mvp.users.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.geekbrains_mvp.databinding.ItemGitHubUserBinding
import com.example.geekbrains_mvp.users.data.model.GitHubUser

class UsersAdapter :
    ListAdapter<GitHubUser, UsersAdapter.GitHubUserViewHolder>(UserDiffUtilCallBack()) {

    var onUserClicked: ((GitHubUser) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubUserViewHolder {
        return GitHubUserViewHolder(
            ItemGitHubUserBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onUserClicked
        )
    }

    override fun onBindViewHolder(holder: GitHubUserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GitHubUserViewHolder(
        private val binding: ItemGitHubUserBinding,
        private val selectUser: ((GitHubUser) -> Unit)?,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GitHubUser) = with(binding.userLogin) {
            text = item.login
            setOnClickListener { selectUser?.invoke(item) }
        }
    }
}

class UserDiffUtilCallBack : DiffUtil.ItemCallback<GitHubUser>() {
    override fun areItemsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
        return oldItem.login == newItem.login
    }
}