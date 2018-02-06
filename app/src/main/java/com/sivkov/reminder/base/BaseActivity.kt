package com.sivkov.reminder.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

abstract class BaseActivity<State : BaseState, ViewModel : BaseViewModel<State>> : AppCompatActivity() {

    protected abstract val vmClass: Class<ViewModel>

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    protected abstract val navigator : Navigator

    protected val viewModel: ViewModel by lazy {
        ViewModelProviders.of(this, factory).get(this.vmClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel.data.observe(this, object : Observer<State> {
            override fun onChanged(t: State) {
                applyChanges(t)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    abstract fun applyChanges(state: State)
}