package com.example.geekbrains_mvp.start.ui

import android.os.Bundle
import com.example.geekbrains_mvp.AppClass
import com.example.geekbrains_mvp.R
import com.example.geekbrains_mvp.start.domain.MainPresenter
import com.example.geekbrains_mvp.start.ui.view.MainView
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {
    @Inject lateinit var navigatorHolder: NavigatorHolder
    @Inject lateinit var router: Router
    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter {
        MainPresenter().apply {
            AppClass.instance.appComponent.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppClass.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}