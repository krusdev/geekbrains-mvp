package com.example.geekbrains_mvp.users.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.geekbrains_mvp.constants.CommonConstants
import com.example.geekbrains_mvp.databinding.FragmentUserBinding
import com.example.geekbrains_mvp.start.ui.fragment.BaseFragment
import com.example.geekbrains_mvp.users.domain.UserPresenter
import com.example.geekbrains_mvp.users.ui.view.UserView
import moxy.ktx.moxyPresenter

class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate), UserView {

    companion object {
        private const val SELECTED_USER_NAME = "selected_user_name"
        private const val SELECTED_USER_REPO_URL = "selected_user_repo_url"

        fun newInstance(userName: String, reposUrl: String) = UserFragment().apply {
            arguments = bundleOf(
                SELECTED_USER_NAME to userName,
                SELECTED_USER_REPO_URL to reposUrl
            )
        }
    }

    private val presenter by moxyPresenter { UserPresenter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setUserInfo(
            requireArguments().getString(
                SELECTED_USER_NAME,
                CommonConstants.DEFAULT_EMPTY_STRING
            ),
            requireArguments().getString(
                SELECTED_USER_REPO_URL,
                CommonConstants.DEFAULT_EMPTY_STRING
            )
        )
    }

    override fun setUserInfo(login: String, reposUrl: String) = with(binding) {
        userName.text = login
        repoUrl.text = reposUrl
    }
}