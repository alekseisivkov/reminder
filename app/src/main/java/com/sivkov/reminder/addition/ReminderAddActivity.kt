package com.sivkov.reminder.addition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sivkov.reminder.R
import com.sivkov.reminder.base.BaseActivity
import com.sivkov.reminder.base.navigation.ActivityNavigator
import dagger.Lazy
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class ReminderAddActivity : BaseActivity<ReminderAddState, ReminderAddViewModel>() {

    companion object {
        fun create(context: Context): Intent {
            return Intent(context, ReminderAddActivity::class.java)
        }
    }

    override val navigator: Navigator by lazy {
        activityNavigator.get()
    }

    override val vmClass = ReminderAddViewModel::class.java

    @Inject
    lateinit var activityNavigator: Lazy<ActivityNavigator>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun applyChanges(state: ReminderAddState) {

    }
}
