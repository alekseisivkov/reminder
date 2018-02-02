package com.sivkov.reminder.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer

open class BaseLiveData<State : BaseState>(state: State) : MutableLiveData<State>() {
    init {
        value = state
    }

    override fun getValue(): State {
        return super.getValue() ?: throw IllegalStateException("Value cannot be null. Check generateEmptyState() method")
    }

    fun observe(owner: LifecycleOwner, observer: com.sivkov.reminder.base.Observer<State>) {
        super.observe(owner, Observer {
            it?.let {
                observer.onChanged(it)
            }
        })
    }

    fun notifyObservers() {
        value = value
    }
}