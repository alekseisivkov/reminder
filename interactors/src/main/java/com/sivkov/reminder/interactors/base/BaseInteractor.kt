package com.sivkov.reminder.interactors.base


abstract class BaseInteractor<out Result : Any> {

    abstract suspend fun execute(): Result
}