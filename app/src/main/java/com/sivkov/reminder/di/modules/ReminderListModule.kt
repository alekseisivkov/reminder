package com.sivkov.reminder.di.modules

import android.app.Activity
import com.sivkov.reminder.di.scopes.PerActivity
import com.sivkov.reminder.list.ReminderListActivity
import dagger.Binds
import dagger.Module


@Module
interface ReminderListModule {

    @PerActivity
    @Binds
    fun provideActivity(activity: ReminderListActivity) : Activity

}