package com.example.geekbrains_mvp.users.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.geekbrains_mvp.AppClass
import com.example.geekbrains_mvp.databinding.FragmentUserListBinding
import com.example.geekbrains_mvp.start.ui.fragment.BaseFragment
import com.example.geekbrains_mvp.users.data.model.GitHubUser
import com.example.geekbrains_mvp.users.domain.UserListPresenter
import com.example.geekbrains_mvp.users.ui.adapter.UsersAdapter
import com.example.geekbrains_mvp.users.ui.view.UserListView
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

    /*temp mock users list*/
    private val usersList = listOf(
        GitHubUser("Dean_Winchester"),
        GitHubUser("Sam_Winchester"),
        GitHubUser("John_Winchester"),
        GitHubUser("Mary_Winchester"),
        GitHubUser("John_Lennon"),
        GitHubUser("Superman"),
        GitHubUser("Batman"),
        GitHubUser("OneMoreUser"),
        GitHubUser("OneMoreLongNamedUser"),
        GitHubUser("LastMockUser"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        userList.adapter = usersAdapter.apply {
            onUserClicked = { user -> presenter.selectUser(user.login) }
        }
        presenter.submitUsersList(usersList)
    }

    override fun submitUserList(list: List<GitHubUser>) {
        usersAdapter.submitList(list)
    }
}