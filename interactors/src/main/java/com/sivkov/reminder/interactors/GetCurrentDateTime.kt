package com.sivkov.reminder.interactors

import com.sivkov.reminder.interactors.base.BaseInteractor
import com.sivkov.reminder.interactors.manager.TimeManager
import org.joda.time.DateTime
import javax.inject.Inject


class GetCurrentDateTime
@Inject constructor(private val timeManager: TimeManager) : BaseInteractor<DateTime>() {

    override suspend fun execute(): DateTime {
        return timeManager.currentDateTime()
    }

}