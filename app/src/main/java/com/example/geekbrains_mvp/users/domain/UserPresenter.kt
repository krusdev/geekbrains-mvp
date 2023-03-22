package com.example.geekbrains_mvp.users.domain

import com.example.geekbrains_mvp.users.ui.view.UserView
import moxy.MvpPresenter

class UserPresenter : MvpPresenter<UserView> () {
    fun setUserLogin(login: String) {
        viewState.setUserLogin(login)
    }
}