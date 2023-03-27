package com.example.geekbrains_mvp.users.data.repository

import com.example.geekbrains_mvp.users.data.GitHubService
import com.example.geekbrains_mvp.users.data.model.GitHubUser
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

interface GitHubRepository {
    fun getUsers() : Observable<List<GitHubUser>>
}

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubService: GitHubService
) : GitHubRepository {

    override fun getUsers() = gitHubService.getUsersList()

}