package com.sivkov.reminder.interactors.manager

import org.joda.time.DateTime

/**
 * Created by Aleksei_Sivkov on 08.02.2018.
 */
interface TimeManager {
    fun currentDateTime(): DateTime
}