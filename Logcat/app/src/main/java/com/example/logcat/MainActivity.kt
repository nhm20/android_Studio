package com.example.logcat

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Get references to the TextViews
        val textViewGreeting: TextView = findViewById(R.id.textViewGreeting)
        val textViewDescription: TextView = findViewById(R.id.textViewDescription)
        var langbtn=findViewById<Button>(R.id.btn2)
        val langentn=findViewById<Button>(R.id.btn)
        textViewGreeting.text = getString(R.string.greeting)
        textViewDescription.text = getString(R.string.description)

        // Set the app name dynamically (if you want to set it programmatically)
        title = getString(R.string.app_name)

        var logEntry=findViewById<Button>(R.id.btn)
        logEntry.setOnClickListener{
            Log.v(TAG,"Verbose log: lowest priority,detailed entry,no use during product")
            Log.d(TAG,"Debug log: highest priority,This is used to debug the app")
            Log.i(TAG,"Info log: moderate priority importance, they give info of ")
            Log.w(TAG,"Warning log: This is a warning message for unexpected behaviour")
        }
        langbtn.setOnClickListener {
            setLocale("es")  // Switch to Spanish
        }
        langentn.setOnClickListener{
            setLocale("en")
        }
    }

    fun setLocale(languageCode: String) {
        val current = resources.configuration.locales.get(0).language
        if (current != languageCode) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val config = Configuration(resources.configuration)
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
            recreate()
        }
    }

}