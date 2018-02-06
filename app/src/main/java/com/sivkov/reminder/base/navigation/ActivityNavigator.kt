package com.sivkov.reminder.base.navigation

import android.app.Activity
import android.widget.Toast
import com.sivkov.reminder.addition.ReminderAddActivity
import com.sivkov.reminder.base.logger.Logger
import com.sivkov.reminder.di.scopes.PerActivity
import com.sivkov.reminder.list.ReminderListActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.*
import javax.inject.Inject

/**
 * Created by Aleksei_Sivkov on 05.02.2018.
 */
@PerActivity
class ActivityNavigator
@Inject constructor(
        private val activity: Activity,
        private val logger: Logger
) : Navigator {

    private val logTag = logger.generateTag(ActivityNavigator::class)

    override fun applyCommands(commands: Array<out Command>) {
        commands.forEach(this::apply)
    }

    private fun apply(command: Command) = when (command) {
        is Forward -> forward(command)
        is Replace -> replace(command)
        is Back -> back()
        is SystemMessage -> systemMessage(command)
        else -> throw IllegalArgumentException("Unknown command type")
    }

    private fun forward(forward: Forward) {
        logger.d(logTag, "Forwarding from $activity to ${forward.screenKey}")

        when (forward.screenKey) {
            ScreenKeys.MAIN.key -> activity.startActivity(ReminderListActivity.create(activity))
            ScreenKeys.ADDITION.key -> activity.startActivity(ReminderAddActivity.create(activity))
            else -> throw IllegalArgumentException("Unknown screen ${forward.screenKey}")
        }
    }

    private fun replace(replace: Replace) {
        logger.d(logTag, "Replacing $activity with ${replace.screenKey}")

        forward(Forward(replace.screenKey, replace.transitionData))
        activity.finish()
    }

    private fun back() {
        logger.d(logTag, "Move back in $activity")

        activity.finish()
    }


    private fun systemMessage(systemMessage: SystemMessage) {
        // TODO: 05.02.2018 replace with specific manager for that
        Toast.makeText(activity, systemMessage.message, Toast.LENGTH_SHORT).show()
    }
}