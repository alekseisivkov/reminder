package com.sivkov.reminder.base

import android.app.Activity
import android.app.Application
import com.sivkov.reminder.di.base.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class MobileApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var injector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector() = injector

}