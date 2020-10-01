package com.example.lesson41

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.custom_dialog.*
import java.util.*
import kotlin.concurrent.schedule

class CustomDialog(context: Context, activity: MainActivity): Dialog(context) {

    private var adapter:ListAdapter = ListAdapter(activity)

    var models: MutableList<Homes> = mutableListOf()

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        setData()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 5, GridLayoutManager.VERTICAL, false)

        swipeRefreshLayout.setOnRefreshListener {
            updateData()
        }

        swipeRefreshLayout.setColorSchemeColors(
            R.color.colorAccent,
            R.color.colorPrimary,
            R.color.colorPrimaryDark,
        )

        btnPositiv.setOnClickListener {
            adapter.selectedItem()
            dismiss()
        }
        btnNegativ.setOnClickListener {
            dismiss()
        }
    }

    private fun updateData() {
        Timer().schedule(2000){
            adapter.setData(models.shuffled() as MutableList<Homes>)
            if (swipeRefreshLayout.isRefreshing) {
                swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    fun setData() {
        for (i in 0 until 100) {
            var model: Homes = Homes()
            model.item = i + 1
            models.add(model)
        }
        adapter.setData(models)
    }
}