package com.example.geekbrains_mvp.users.domain

import com.example.geekbrains_mvp.start.domain.IScreens
import com.example.geekbrains_mvp.users.domain.model.User
import com.example.geekbrains_mvp.users.domain.usecase.GetUsersList
import com.example.geekbrains_mvp.users.ui.view.UserListView
import com.github.terrakok.cicerone.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UserListPresenter : MvpPresenter<UserListView>() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var getUsers: GetUsersList
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposables.add(getUsers().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { users -> submitUsersList(users.map { it.toUser() }) },
                { error -> handleError(error.message) }
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    private fun submitUsersList(list: List<User>) {
        viewState.submitUserList(list)
    }

    private fun handleError(message: String?) = viewState.showSnack(message)


    fun selectUser(userLogin: String) = router.navigateTo(screens.user(userLogin))
}