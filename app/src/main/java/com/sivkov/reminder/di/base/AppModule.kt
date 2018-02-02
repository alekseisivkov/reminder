package com.sivkov.reminder.di.base

import android.content.Context
import com.sivkov.reminder.base.MobileApplication
import com.sivkov.reminder.di.ReminderListModule
import com.sivkov.reminder.di.scopes.PerActivity
import com.sivkov.reminder.list.ReminderListActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Module(includes = [AndroidSupportInjectionModule::class, AppModule.Declaration::class])
object AppModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideContext(app: MobileApplication): Context {
        return app.applicationContext
    }

    @Module
    interface Declaration {

        @PerActivity
        @ContributesAndroidInjector(modules = [ReminderListModule::class])
        fun reminderActivityInjector(): ReminderListActivity

    }
}