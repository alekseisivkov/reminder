package com.sivkov.reminder.di.base

import com.sivkov.reminder.base.MobileApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: MobileApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: MobileApplication)
}