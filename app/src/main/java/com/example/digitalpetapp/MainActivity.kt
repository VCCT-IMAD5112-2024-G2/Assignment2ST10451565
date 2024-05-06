package com.example.digitalpetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSwitcher = findViewById<Button>(R.id.btnSwitcher)
        btnSwitcher.setOnClickListener {
            // create the explicit intent
            val intent = Intent(this, SecondPage::class.java)



            startActivity(intent)
        }


    }
}