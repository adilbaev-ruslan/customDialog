package com.example.lesson41

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.coroutines.*

class CustomDialog(context: Context, activity: MainActivity): Dialog(context) {

    private var adapter:ListAdapter = ListAdapter(activity)

    var models: MutableList<Homes> = mutableListOf()

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        setData()
        recyclerView.adapter = adapter

        swipeRefreshLayout.setOnRefreshListener {
            updateData()
        }

        swipeRefreshLayout.setColorSchemeColors(
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

    private fun setData() {
        for (i in 0 until 100) {
            var model: Homes = Homes()
            model.item = i + 1
            models.add(model)
        }
        adapter.setData(models)
    }

    private fun updateData() {
        GlobalScope.launch (Dispatchers.IO) {
            delay(2000)
            withContext(Dispatchers.Main) {
                adapter.setData(models)
                if (swipeRefreshLayout.isRefreshing) {
                    swipeRefreshLayout.isRefreshing = false
                }
            }
        }
    }
}