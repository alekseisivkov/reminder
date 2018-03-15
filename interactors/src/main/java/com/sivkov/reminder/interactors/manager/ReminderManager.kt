package com.sivkov.reminder.interactors.manager

import com.sivkov.reminder.entities.Reminder

interface ReminderManager {

    fun create(reminder: Reminder)
}