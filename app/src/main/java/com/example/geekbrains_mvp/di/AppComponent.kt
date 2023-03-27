package com.example.geekbrains_mvp.di

import com.example.geekbrains_mvp.start.domain.MainPresenter
import com.example.geekbrains_mvp.start.domain.StartPresenter
import com.example.geekbrains_mvp.start.ui.MainActivity
import com.example.geekbrains_mvp.users.domain.UserListPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class, GitHubModule::class, UseCasesModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(startPresenter: StartPresenter)
    fun inject(userListPresenter: UserListPresenter)

}