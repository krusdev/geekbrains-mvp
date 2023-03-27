package com.example.geekbrains_mvp.users.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.geekbrains_mvp.AppClass
import com.example.geekbrains_mvp.R
import com.example.geekbrains_mvp.constants.CommonConstants
import com.example.geekbrains_mvp.databinding.FragmentUserListBinding
import com.example.geekbrains_mvp.start.ui.fragment.BaseFragment
import com.example.geekbrains_mvp.users.domain.UserListPresenter
import com.example.geekbrains_mvp.users.domain.model.User
import com.example.geekbrains_mvp.users.ui.adapter.UsersAdapter
import com.example.geekbrains_mvp.users.ui.view.UserListView
import com.google.android.material.snackbar.Snackbar
import moxy.ktx.moxyPresenter

class UserListFragment : BaseFragment<FragmentUserListBinding>(FragmentUserListBinding::inflate),
    UserListView {

    companion object {
        fun newInstance() = UserListFragment()
    }

    private val presenter by moxyPresenter {
        UserListPresenter().apply {
            AppClass.instance.appComponent.inject(this)
        }
    }

    private val usersAdapter by lazy { UsersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        userList.adapter = usersAdapter.apply {
            onUserClicked = { user -> presenter.selectUser(user.login, user.reposUrl) }
        }
    }

    override fun submitUserList(list: List<User>) {
        usersAdapter.submitList(list)
    }

    override fun showSnack(message: String?) = when {
        !message.isNullOrEmpty() -> Snackbar.make(binding.root, message, CommonConstants.SNACK_BAR_DEFAULT_LENGTH).show()
        else -> Snackbar.make(binding.root, getString(R.string.unexpected_error), CommonConstants.SNACK_BAR_DEFAULT_LENGTH).show()
    }
}