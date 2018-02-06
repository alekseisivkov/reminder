package com.sivkov.reminder.di.modules

import android.app.Activity
import com.sivkov.reminder.addition.ReminderAddActivity
import com.sivkov.reminder.di.scopes.PerActivity
import dagger.Binds
import dagger.Module

@Module
interface ReminderAddModule {

    @PerActivity
    @Binds
    fun provideActivity(activity: ReminderAddActivity) : Activity
}