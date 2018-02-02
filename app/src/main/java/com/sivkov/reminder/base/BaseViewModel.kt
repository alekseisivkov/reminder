package com.sivkov.reminder.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel<State : BaseState>(state: State) : ViewModel() {

    val data: BaseLiveData<State> = BaseLiveData(state)
}