package com.example.lesson41

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class ListAdapter(val activity: MainActivity): RecyclerView.Adapter<ListViewHolder>() {

    var models: MutableList<Homes> = mutableListOf()

    var rowIndex:Int = -1

    fun setData(data: MutableList<Homes>) {
        models = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModel(models[position], activity)
        holder.itemView.setOnClickListener {
            rowIndex = position
            notifyDataSetChanged()
        }
        if (rowIndex == position) {
            holder.itemView.tvItem.setBackgroundResource(R.drawable.select_item)
        } else {
            holder.itemView.tvItem.setBackgroundResource(0)
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }

    fun selectedItem() {
        activity.etHome.setText("Квартира: ${rowIndex+1}")
    }
}