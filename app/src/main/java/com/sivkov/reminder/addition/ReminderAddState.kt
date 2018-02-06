package com.sivkov.reminder.addition

import com.sivkov.reminder.base.BaseState


class ReminderAddState : BaseState() {
    var message: String = ""
    var displayDate: String = "Select date"
    var displayTime: String = "Select time"
}