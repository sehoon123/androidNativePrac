package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get phone number from intent
        val phoneNum = intent.getStringExtra("phoneNum")

        // show toast
        Toast.makeText(this, "You can't call to ${phoneNum}", Toast.LENGTH_SHORT).show()

        // finish activity and return to previous activity
        finish()
    }
}