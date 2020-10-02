package com.example.lesson41

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun populateModel(homes: Homes){
        itemView.tvItem.text = homes.item.toString()
    }
}