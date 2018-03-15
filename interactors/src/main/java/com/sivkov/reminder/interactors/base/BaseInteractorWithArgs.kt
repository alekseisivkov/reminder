package com.sivkov.reminder.interactors.base

abstract class BaseInteractorWithArgs<Args : Any, out Result : Any> : BaseInteractor<Result>() {

    protected lateinit var args: Args

    fun args(args: Args): BaseInteractorWithArgs<Args, Result> {
        this.args = args
        return this
    }
}