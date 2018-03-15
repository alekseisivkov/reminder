package com.sivkov.reminder.addition

import com.sivkov.reminder.base.BaseViewModel
import com.sivkov.reminder.interactors.CreateReminder
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class ReminderAddViewModel
@Inject constructor(
        private val router: Router,
        private val createReminder: CreateReminder)
    : BaseViewModel<ReminderAddState>(ReminderAddState()) {

    init {
        data.value.apply {

        }
    }

    fun onSaveClicked() {
        launch(CommonPool) { createReminder() }
        router.exit()
    }

    fun onMessageChanged(message: String) {
        data.value.message = message
    }

    fun onDateChanged(dayOfMonth: Int, monthOfYear: Int, year: Int) {
        data.value.apply {
            displayDate = "$dayOfMonth.$monthOfYear.$year"
            this.dayOfMonth = dayOfMonth
            this.monthOfYear = monthOfYear
            this.year = year
        }
        data.notifyObservers()
    }

    fun onTimeChanged(hourOfDay: Int, minute: Int) {
        data.value.apply {
            displayTime = "$hourOfDay:$minute"
            this.hourOfDay = hourOfDay
            this.minute = minute
        }
        data.notifyObservers()
    }

    private suspend fun createReminder() {
        val args = with(data.value, {
            CreateReminder.Args(dayOfMonth, monthOfYear, year, hourOfDay, minute, message)
        })
        createReminder.args(args).execute()
    }
}