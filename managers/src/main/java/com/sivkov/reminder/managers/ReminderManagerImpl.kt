package com.sivkov.reminder.managers

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.sivkov.reminder.entities.Reminder
import com.sivkov.reminder.interactors.manager.ReminderManager
import com.sivkov.reminder.tools.ACTION_ALERT_REMINDER
import com.sivkov.reminder.tools.EXTRA_REMINDER_TEXT
import com.sivkov.reminder.tools.Logger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReminderManagerImpl
@Inject constructor(private val context: Context, private val logger: Logger) : ReminderManager {

    private val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    private val rcAlarm = 1
    private val logTag = logger.generateTag(ReminderManagerImpl::class)

    override fun create(reminder: Reminder) {
        logger.d(logTag, "Creating reminder $reminder")

        val data = Intent(ACTION_ALERT_REMINDER)
        data.putExtra(EXTRA_REMINDER_TEXT, reminder.text)

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, reminder.time, PendingIntent.getActivity(context, rcAlarm, data, 0))
    }
}