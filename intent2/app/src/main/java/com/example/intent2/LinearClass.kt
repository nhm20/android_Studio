package com.example.intent2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LinearClass : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.linear)
        var details=findViewById<TextView>(R.id.tv)
        var name=intent.getStringExtra("Name")?:"no Name Provided"
        var gender=intent.getStringExtra("Gender")?:"No Gender provided"
        details.text="$name\n$gender"

        if(details!=null){
            Toast.makeText(this,"Data Received",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Data Not Received",Toast.LENGTH_LONG).show()
        }

    }
}