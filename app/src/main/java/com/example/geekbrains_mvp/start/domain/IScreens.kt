package com.example.geekbrains_mvp.start.domain

import com.example.geekbrains_mvp.start.ui.fragment.StartFragment
import com.example.geekbrains_mvp.users.ui.fragment.UserFragment
import com.example.geekbrains_mvp.users.ui.fragment.UserListFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface IScreens {
    fun start(): Screen
    fun userList(): Screen
    fun user(login: String, reposUrl: String): Screen
}

class AndroidScreens : IScreens {
    override fun start() = FragmentScreen { StartFragment.newInstance() }
    override fun userList() = FragmentScreen { UserListFragment.newInstance() }
    override fun user(login: String, reposUrl: String) = FragmentScreen { UserFragment.newInstance(login, reposUrl) }
}