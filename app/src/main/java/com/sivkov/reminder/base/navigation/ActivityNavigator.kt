package com.sivkov.reminder.base.navigation

import android.app.Activity
import android.widget.Toast
import com.sivkov.reminder.addition.ReminderAddActivity
import com.sivkov.reminder.di.scopes.PerActivity
import com.sivkov.reminder.list.ReminderListActivity
import com.sivkov.reminder.tools.Logger
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.*
import javax.inject.Inject


@PerActivity
open class ActivityNavigator
@Inject constructor(
        private val activity: Activity,
        private val logger: Logger
) : Navigator {

    private val logTag = logger.generateTag(ActivityNavigator::class)

    override fun applyCommands(commands: Array<out Command>) {
        commands.forEach(this::apply)
    }

    protected fun apply(command: Command) = when (command) {
        is Forward -> forward(command)
        is Replace -> replace(command)
        is Back -> back()
        is SystemMessage -> systemMessage(command)
        else -> throw IllegalArgumentException("Unknown command type")
    }

    protected fun forward(forward: Forward) {
        logger.d(logTag, "Forwarding from $activity to ${forward.screenKey}")

        when (forward.screenKey) {
            ScreenKeys.MAIN.key -> activity.startActivity(ReminderListActivity.create(activity))
            ScreenKeys.ADDITION.key -> activity.startActivity(ReminderAddActivity.create(activity))
            else -> throw IllegalArgumentException("Unknown screen ${forward.screenKey}")
        }
    }

    protected fun replace(replace: Replace) {
        logger.d(logTag, "Replacing $activity with ${replace.screenKey}")

        forward(Forward(replace.screenKey, replace.transitionData))
        activity.finish()
    }

    protected fun back() {
        logger.d(logTag, "Move back in $activity")

        activity.finish()
    }


    protected fun systemMessage(systemMessage: SystemMessage) {
        // TODO: 05.02.2018 replace with specific manager for that
        Toast.makeText(activity, systemMessage.message, Toast.LENGTH_SHORT).show()
    }
}