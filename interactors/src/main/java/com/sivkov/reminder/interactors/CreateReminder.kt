package com.sivkov.reminder.interactors

import com.sivkov.reminder.interactors.base.BaseInteractorWithArgs
import com.sivkov.reminder.interactors.manager.ReminderManager
import com.sivkov.reminder.interactors.mapper.ArgsReminderMapper
import javax.inject.Inject

class CreateReminder @Inject constructor(
        private val reminderManager: ReminderManager,
        private val mapper: ArgsReminderMapper
) : BaseInteractorWithArgs<CreateReminder.Args, Unit>() {

    override suspend fun execute() {
        reminderManager.create(mapper.map(args))
    }

    class Args(val dayOfMonth: Int, val monthOfYear: Int, val year: Int,
               val hourOfDay: Int, val minute: Int,
               val text: String)

}