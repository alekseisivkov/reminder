package com.sivkov.reminder.di.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sivkov.reminder.addition.ReminderAddViewModel
import com.sivkov.reminder.base.BaseViewModelFactory
import com.sivkov.reminder.list.ReminderListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ReminderListViewModel::class)
    fun bindListViewModel(vm: ReminderListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReminderAddViewModel::class)
    fun bindAddViewModel(vm: ReminderAddViewModel): ViewModel

    @Binds
    @Singleton
    fun bindFactory(factory: BaseViewModelFactory): ViewModelProvider.Factory
}