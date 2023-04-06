package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // register for activity result
    val requestLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),{
        // check if result is ok
        if (it.resultCode == Activity.RESULT_OK) {
            // get phone number from intent
            val phoneNum = it.data?.getStringExtra("phoneNum")

            // show toast
            Toast.makeText(this, "You can't call to ${phoneNum}", Toast.LENGTH_SHORT).show()
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // enable viewBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set onClickListener for button
        binding.btnReply.setOnClickListener({
            // get phone number from user input
            val phoneNumber = binding.txtReply.text.toString()

            // parse phone number to uri
            val uri = Uri.parse("tel:$phoneNumber")

            // create intent
            val intent = Intent(Intent.ACTION_DIAL, uri)

            // put phone number to intent for next activity
            intent.putExtra("phoneNum", phoneNumber)

            // create chooser
            val chooser = Intent.createChooser(intent, "Which app to use?")

            requestLauncher.launch(chooser)
        })
    }
}