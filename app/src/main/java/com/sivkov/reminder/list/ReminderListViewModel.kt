package com.sivkov.reminder.list

import com.sivkov.reminder.base.BaseViewModel
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.util.*

/**
 * Created by Aleksei_Sivkov on 31.01.2018.
 */
class ReminderListViewModel : BaseViewModel<ReminderListState>(ReminderListState()) {

    fun onAddClicked() {
        launch(UI) {
            val result = async(CommonPool) {
                createList()
            }
            data.value.reminders = result.await()
            data.notifyObservers()
        }
    }

    private fun createList(): List<ReminderModel> {
        val emptyList: MutableList<ReminderModel> = ArrayList()
        for (i in 1..Random().nextInt(40)) {
            emptyList.add(ReminderModel("New reminder $i", System.currentTimeMillis().toString()))
        }
        return emptyList
    }
}