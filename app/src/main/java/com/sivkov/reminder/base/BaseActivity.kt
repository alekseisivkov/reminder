package com.sivkov.reminder.base

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<State : BaseState, ViewModel : BaseViewModel<State>> : AppCompatActivity() {

    protected abstract val vmClass: Class<ViewModel>

    protected val viewModel: ViewModel by lazy {
        ViewModelProviders.of(this).get(this.vmClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.data.observe(this, object : Observer<State> {
            override fun onChanged(t: State) {
                applyChanges(t)
            }
        })
    }

    abstract fun applyChanges(state: State)
}