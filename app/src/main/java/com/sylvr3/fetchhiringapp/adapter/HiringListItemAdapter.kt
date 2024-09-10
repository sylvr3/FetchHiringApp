package com.sylvr3.fetchhiringapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sylv3.fetchhiringapp.R
import com.sylvr3.fetchhiringapp.model.HiringListItem

class HiringListItemAdapter(private val data: List<HiringListItem>) :
    RecyclerView.Adapter<HiringListItemAdapter.DataItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return DataItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataItemViewHolder, position: Int) {
        val item = data[position]
        holder.nameTextView.text = "Name: ${item.name}"
        holder.idTextView.text = "Id: ${item.id}"
        holder.listIdTextView.text = "ListId: ${item.listId}"
    }

    override fun getItemCount(): Int = data.size

    class DataItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val idTextView: TextView = itemView.findViewById(R.id.idTextView)
        val listIdTextView: TextView = itemView.findViewById(R.id.listIdTextView)
    }
}
