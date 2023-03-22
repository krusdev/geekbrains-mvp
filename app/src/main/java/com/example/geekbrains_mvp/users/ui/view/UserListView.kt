package com.example.geekbrains_mvp.users.ui.view

import com.example.geekbrains_mvp.users.data.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserListView : MvpView {
    fun submitUserList(list: List<GitHubUser>)
}