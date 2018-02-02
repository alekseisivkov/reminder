package com.sivkov.reminder.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.sivkov.reminder.R
import com.sivkov.reminder.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class ReminderListActivity : BaseActivity<ReminderListState, ReminderListViewModel>(), View.OnClickListener, ReminderListAdapter.Callback {

    override val vmClass = ReminderListViewModel::class.java

    private val adapter = ReminderListAdapter()

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
