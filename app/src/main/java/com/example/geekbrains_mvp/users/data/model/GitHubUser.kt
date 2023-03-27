package com.example.geekbrains_mvp.users.data.model

import com.example.geekbrains_mvp.users.domain.model.User
import com.google.gson.annotations.SerializedName

data class GitHubUser(
    val login: String,
    @SerializedName("repos_url")
    val reposUrl: String
) {
    fun toUser() = User(login, reposUrl)
}