package com.example.geekbrains_mvp.users.data

import com.example.geekbrains_mvp.users.data.model.GitHubUser
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface GitHubService {
    @GET("/users")
    fun getUsersList(): Observable<List<GitHubUser>>
}