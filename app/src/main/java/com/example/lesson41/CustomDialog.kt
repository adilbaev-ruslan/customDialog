package com.example.lesson41

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.custom_dialog.*

class CustomDialog(context: Context, activity: MainActivity): Dialog(context) {

    private var adapter:ListAdapter = ListAdapter(activity)

    var models: MutableList<Homes> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        setData()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 5, GridLayoutManager.VERTICAL, false)

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
}