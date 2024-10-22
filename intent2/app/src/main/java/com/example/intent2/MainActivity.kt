package com.example.intent2

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var btn=findViewById<Button>(R.id.btn)
        var name=findViewById<EditText>(R.id.et)
        var gender=findViewById<EditText>(R.id.et2)
        btn.setOnClickListener{
            val i=Intent(this,LinearClass::class.java)
            Log.i(TAG,"Details Entered Navigate to Welcom Page")
            i.putExtra("Name",name.text.toString())
            i.putExtra("Gender",gender.text.toString())
            startActivity(i)
        }
    }
}