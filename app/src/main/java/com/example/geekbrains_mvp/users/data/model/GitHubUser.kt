package com.example.geekbrains_mvp.users.data.model

import com.example.geekbrains_mvp.users.domain.model.User

data class GitHubUser(
    val login: String
) {
    fun toUser() = User(login)
}