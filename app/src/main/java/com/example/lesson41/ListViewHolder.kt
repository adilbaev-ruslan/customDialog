package com.example.lesson41

import android.text.style.BackgroundColorSpan
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun populateModel(homes: Homes, activity: MainActivity){
        itemView.tvItem.text = homes.item.toString()
    }
}