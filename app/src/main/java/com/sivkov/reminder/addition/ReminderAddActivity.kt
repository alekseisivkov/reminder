package com.sivkov.reminder.addition

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sivkov.reminder.R
import com.sivkov.reminder.base.BaseActivity
import com.sivkov.reminder.base.navigation.ActivityNavigator
import com.sivkov.reminder.utils.doOnTextChanged
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_add.*
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class ReminderAddActivity : BaseActivity<ReminderAddState, ReminderAddViewModel>() {

    companion object {
        fun create(context: Context): Intent {
            return Intent(context, ReminderAddActivity::class.java)
        }
    }

    override val navigator: Navigator by lazy {
        activityNavigator.get()
    }

    override val vmClass = ReminderAddViewModel::class.java

    @Inject
    lateinit var activityNavigator: Lazy<ActivityNavigator>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        button_save.setOnClickListener { viewModel.onSaveClicked() }

        message.doOnTextChanged { viewModel.onMessageChanged(it.toString()) }

        date_picker.setOnClickListener {
            DatePickerDialog(this,
                             { _, year, month, dayOfMonth ->
                                 viewModel.onDateChanged(dayOfMonth, month, year)
                             },
                             2018, 1, 1).show()
        }

        time_picker.setOnClickListener {
            TimePickerDialog(this,
                             { _, hourOfDay, minute -> viewModel.onTimeChanged(hourOfDay, minute) },
                             10, 10, true).show()
        }
    }

    override fun applyChanges(state: ReminderAddState) {
        date_picker.text = state.displayDate
        time_picker.text = state.displayTime
    }
}
