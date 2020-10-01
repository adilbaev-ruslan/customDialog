package com.example.lesson41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOption.setOnClickListener {
            val dialog:CustomDialog = CustomDialog(this, this)
            dialog.show()
        }
    }
}