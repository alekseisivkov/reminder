package com.sivkov.reminder.interactors.mapper

import com.sivkov.reminder.entities.Reminder
import com.sivkov.reminder.interactors.CreateReminder
import com.sivkov.reminder.tools.Mapper
import javax.inject.Inject


class ArgsReminderMapper
@Inject constructor(private val dateMapper: DateMapper) : Mapper<CreateReminder.Args, Reminder>() {

    override fun map(from: CreateReminder.Args): Reminder {
        return Reminder(dateMapper.map(from), from.text)
    }
}