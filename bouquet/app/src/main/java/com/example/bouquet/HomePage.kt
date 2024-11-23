package com.example.bouquet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.sbm)
        val name = intent.getStringExtra("name")
        val pass = intent.getStringExtra("pass")

        // Now you can use the values `name` and `pass`
        println("Name: $name, Password: $pass")
    }
}