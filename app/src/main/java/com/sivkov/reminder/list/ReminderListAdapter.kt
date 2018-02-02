package com.sivkov.reminder.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sivkov.reminder.R
import com.sivkov.reminder.di.scopes.PerActivity
import javax.inject.Inject


@PerActivity
class ReminderListAdapter
@Inject constructor() : RecyclerView.Adapter<ReminderListAdapter.ViewHolder>() {

    private var data: List<ReminderModel> = emptyList()

    init {
        setHasStableIds(true)
    }

    var callback: Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_reminder, parent, false)
        val vh = ViewHolder(view)
        view.setOnClickListener { callback?.onItemClick(getItem(vh.adapterPosition)) }
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.title.text = item.text
        holder.content.text = item.date
    }

    override fun getItemCount() = data.size

    override fun getItemId(position: Int): Long {
        return getItem(position).hashCode().toLong()
    }

    fun getItem(position: Int) = data[position]

    fun setData(data: List<ReminderModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClick(model: ReminderModel)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val content: TextView = view.findViewById(R.id.content)
    }
}