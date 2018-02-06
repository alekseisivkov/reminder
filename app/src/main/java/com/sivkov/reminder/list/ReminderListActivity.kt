package com.sivkov.reminder.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.sivkov.reminder.R
import com.sivkov.reminder.base.BaseActivity
import com.sivkov.reminder.base.navigation.ActivityNavigator
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import javax.inject.Inject

class ReminderListActivity : BaseActivity<ReminderListState, ReminderListViewModel>(), View.OnClickListener, ReminderListAdapter.Callback {

    companion object {
        fun create(context: Context): Intent {
            return Intent(context, ReminderListActivity::class.java)
        }
    }

    override val navigator: Navigator by lazy {
        activityNavigator.get()
    }

    override val vmClass = ReminderListViewModel::class.java

    @Inject
    lateinit var adapter: ReminderListAdapter

    @Inject
    lateinit var activityNavigator: Lazy<ActivityNavigator>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.adapter = adapter
        adapter.callback = this
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        fab.setOnClickListener(this)
    }

    override fun applyChanges(state: ReminderListState) {
        adapter.setData(state.reminders)
    }

    override fun onClick(button: View) {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show()
        viewModel.onAddClicked()
    }

    override fun onItemClick(model: ReminderModel) {

    }

}
