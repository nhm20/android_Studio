package com.example.popupproject

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var languageListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        val button = findViewById<Button>(R.id.btn)
        textView = findViewById(R.id.tv)
        languageListView = findViewById(R.id.list1)

        // Language options
        val languages = arrayOf("English", "Spanish","Telugu")

        // Set up ListView adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        languageListView.adapter = adapter

        // Initially hide the ListView
        languageListView.visibility = android.view.View.GONE

        // Show or hide the ListView on button click
        button.setOnClickListener {
            languageListView.visibility =
                if (languageListView.visibility == android.view.View.GONE) android.view.View.VISIBLE
                else android.view.View.GONE
        }

        // Handle ListView item clicks
        languageListView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> changeLanguage("en") // English
                1 -> changeLanguage("es") // Spanish
                2->changeLanguage("te") // Telugu
            }
            // Hide the ListView after selection
            languageListView.visibility = android.view.View.GONE
        }
    }

    private fun changeLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        // Update configuration with new locale
        val config = Configuration()
        config.setLocale(locale)

        // Apply the configuration to the app resources
        resources.updateConfiguration(config, resources.displayMetrics)

        // Update the TextView with the new language
        textView.text = getString(R.string.home_text) // Fetch the string resource dynamically
    }
}
