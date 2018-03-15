package com.sivkov.reminder.addition

import com.sivkov.reminder.base.BaseState


class ReminderAddState : BaseState() {
    var message: String = ""

    lateinit var displayDate: String
    lateinit var displayTime: String

    var dayOfMonth: Int = 1
    var monthOfYear: Int = 1
    var year: Int = 1970

    var hourOfDay: Int = 12
    var minute: Int = 0
}