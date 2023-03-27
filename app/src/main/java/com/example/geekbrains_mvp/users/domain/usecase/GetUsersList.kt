package com.example.geekbrains_mvp.users.domain.usecase

import com.example.geekbrains_mvp.users.data.model.GitHubUser
import com.example.geekbrains_mvp.users.data.repository.GitHubRepository
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

interface GetUsersList {
    operator fun invoke(): Observable<List<GitHubUser>>
}

class GetUsersListImpl @Inject constructor(
    private val repository: GitHubRepository
) : GetUsersList {
    override operator fun invoke() = repository.getUsers()
}