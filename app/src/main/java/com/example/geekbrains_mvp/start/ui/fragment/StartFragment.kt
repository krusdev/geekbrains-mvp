package com.example.geekbrains_mvp.start.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.geekbrains_mvp.AppClass
import com.example.geekbrains_mvp.databinding.FragmentStartBinding
import com.example.geekbrains_mvp.start.domain.StartPresenter
import com.example.geekbrains_mvp.start.ui.view.StartView
import moxy.ktx.moxyPresenter

class StartFragment : BaseFragment<FragmentStartBinding>(FragmentStartBinding::inflate), StartView {

    companion object {
        fun newInstance() = StartFragment()
    }

    private val presenter by moxyPresenter { StartPresenter().apply {
        AppClass.instance.appComponent.inject(this)
    } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.getUsersButton.setOnClickListener {
            presenter.getUsers()
        }
    }
}