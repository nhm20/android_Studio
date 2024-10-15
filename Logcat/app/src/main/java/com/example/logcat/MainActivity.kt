package com.example.logcat

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var logEntry=findViewById<Button>(R.id.btn)
        logEntry.setOnClickListener{
            Log.v(TAG,"Verbose log: lowest priority,detailed entry,no use during product")
            Log.d(TAG,"Debug log: highest priority,This is used to debug the app")
            Log.i(TAG,"Info log: moderate priority importance, they give info of ")
            Log.w(TAG,"Warning log: This is a warnging message for unexpected behaviour")

        }

    }
}