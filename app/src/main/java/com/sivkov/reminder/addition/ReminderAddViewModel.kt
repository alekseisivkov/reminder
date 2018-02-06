package com.sivkov.reminder.addition

import com.sivkov.reminder.base.BaseViewModel
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class ReminderAddViewModel
@Inject constructor(private val router: Router) : BaseViewModel<ReminderAddState>(ReminderAddState()) {

    fun onSaveClicked() {
        router.exit()
    }

    fun onMessageChanged(message: String) {
        data.value.message = message
    }

    fun onDateChanged(dayOfMonth: Int, monthOfYear: Int, year: Int) {
        data.value.displayDate = "$dayOfMonth.$monthOfYear.$year"
        data.notifyObservers()
    }

    fun onTimeChanged(hourOfDay: Int, minute: Int) {
        data.value.displayTime = "$hourOfDay:$minute"
        data.notifyObservers()
    }
}