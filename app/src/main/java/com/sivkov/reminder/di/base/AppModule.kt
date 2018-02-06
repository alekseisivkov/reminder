package com.sivkov.reminder.di.base

import android.content.Context
import com.sivkov.reminder.addition.ReminderAddActivity
import com.sivkov.reminder.base.MobileApplication
import com.sivkov.reminder.base.logger.DebugLogger
import com.sivkov.reminder.base.logger.Logger
import com.sivkov.reminder.di.modules.ReminderAddModule
import com.sivkov.reminder.di.modules.ReminderListModule
import com.sivkov.reminder.di.scopes.PerActivity
import com.sivkov.reminder.list.ReminderListActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Module(includes = [AndroidSupportInjectionModule::class,
    AppModule.Declaration::class,
    NavigationModule::class,
    ViewModelModule::class])
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

        @PerActivity
        @ContributesAndroidInjector(modules = [ReminderAddModule::class])
        fun reminderAddActivityInjector(): ReminderAddActivity

        // TODO: 05.02.2018 replace with provider method
        @Singleton
        @Binds
        fun provideLogger(logger: DebugLogger): Logger

    }
}