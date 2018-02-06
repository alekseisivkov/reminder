package com.sivkov.reminder.list

import com.sivkov.reminder.base.BaseViewModel
import com.sivkov.reminder.base.navigation.ScreenKeys
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class ReminderListViewModel
@Inject constructor(private val router: Router)
    : BaseViewModel<ReminderListState>(ReminderListState()) {

    fun onAddClicked() {
        launch(UI) {
            val result = async(CommonPool) {
                createList()
            }
            data.value.reminders = result.await()
            data.notifyObservers()
        }
        router.navigateTo(ScreenKeys.ADDITION.key)
    }

    private fun createList(): List<ReminderModel> {
        val emptyList: MutableList<ReminderModel> = ArrayList()
        for (i in 1..Random().nextInt(40)) {
            emptyList.add(ReminderModel("New reminder $i", System.currentTimeMillis().toString()))
        }
        return emptyList
    }
}