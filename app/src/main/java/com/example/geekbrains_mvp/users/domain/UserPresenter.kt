package com.example.geekbrains_mvp.users.domain

import com.example.geekbrains_mvp.users.ui.view.UserView
import moxy.MvpPresenter

class UserPresenter : MvpPresenter<UserView> () {
    fun setUserInfo(login: String, reposUrl: String) {
        viewState.setUserInfo(login, reposUrl)
    }
}