package com.example.geekbrains_mvp.di

import com.example.geekbrains_mvp.users.data.repository.GitHubRepository
import com.example.geekbrains_mvp.users.data.repository.GitHubRepositoryImpl
import com.example.geekbrains_mvp.users.domain.usecase.GetUsersList
import com.example.geekbrains_mvp.users.domain.usecase.GetUsersListImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface UseCasesModule {

    @Singleton
    @Binds
    fun bindGetUsersListImplToGetUsersList(getUsersListImpl: GetUsersListImpl) : GetUsersList

    @Singleton
    @Binds
    fun bindGitHubRepositoryImplToGitHubRepository(gitHubRepositoryImpl: GitHubRepositoryImpl) : GitHubRepository
}