package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    val requestLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val data: Intent? = result.data
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // enable binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReply.setOnClickListener({
//            val phoneNumber = binding.txtReply.text.toString()
            val intent = Intent(Intent.ACTION_DIAL)
            val chooser = Intent.createChooser(intent, "Which app to use?")

            startActivity(chooser)
        })
    }
}