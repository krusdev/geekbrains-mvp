package com.example.geekbrains_mvp.users.domain

import com.example.geekbrains_mvp.start.domain.IScreens
import com.example.geekbrains_mvp.users.data.model.GitHubUser
import com.example.geekbrains_mvp.users.ui.view.UserListView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class UserListPresenter : MvpPresenter<UserListView>() {
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens

    fun submitUsersList(list: List<GitHubUser>) {
        viewState.submitUserList(list)
    }

    fun selectUser(userLogin: String) {
        router.navigateTo(screens.user(userLogin))
    }
}