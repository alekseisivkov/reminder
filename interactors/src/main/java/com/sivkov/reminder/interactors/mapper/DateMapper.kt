package com.sivkov.reminder.interactors.mapper

import com.sivkov.reminder.interactors.CreateReminder
import com.sivkov.reminder.tools.Mapper
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateMapper @Inject constructor() : Mapper<CreateReminder.Args, Long>() {
    private val calendar = Calendar.getInstance()

    override fun map(from: CreateReminder.Args): Long {
        from.apply {
            calendar.set(year, monthOfYear, dayOfMonth, hourOfDay, minute)
        }
        return calendar.timeInMillis
    }

}