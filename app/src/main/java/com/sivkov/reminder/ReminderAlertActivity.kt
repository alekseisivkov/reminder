package com.sivkov.reminder

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager


/**
 * Created by Aleksei_Sivkov on 07.02.2018.
 */
class ReminderAlertActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO: 08.02.2018 implement it
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)

        setContentView(R.layout.activity_add)
    }
}