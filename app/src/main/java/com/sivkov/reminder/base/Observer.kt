package com.sivkov.reminder.base

/**
 * Created by Aleksei_Sivkov on 02.02.2018.
 */
interface Observer<in T> {

    fun onChanged(t: T)
}