package com.example.geekbrains_mvp.start.domain

import com.example.geekbrains_mvp.start.ui.view.StartView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class StartPresenter : MvpPresenter<StartView>() {
    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens

    fun getUsers() = router.navigateTo(screens.userList())
}