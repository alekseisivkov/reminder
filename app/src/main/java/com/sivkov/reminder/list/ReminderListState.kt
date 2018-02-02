package com.sivkov.reminder.list

import com.sivkov.reminder.base.BaseState

/**
 * Created by Aleksei_Sivkov on 31.01.2018.
 */
class ReminderListState : BaseState() {
    var reminders: List<ReminderModel> = emptyList()
}