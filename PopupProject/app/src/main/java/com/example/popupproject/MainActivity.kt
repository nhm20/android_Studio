package com.example.popupproject

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var subbtn=findViewById<Button>(R.id.btn)
        var textview=findViewById<TextView>(R.id.tv)

        subbtn.setOnClickListener {
            val customDialog = LayoutInflater.from(this).inflate(R.layout.select_lang, null)

            val dialog = AlertDialog.Builder(this)
                .setView(customDialog)
                .create()
            val languageListView: ListView = customDialog.findViewById(R.id.list1)

            val languages = arrayOf("English", "Telugu", "Japanese")
            val locales= arrayOf("en","te","ja")

            val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
            languageListView.adapter = listAdapter

            languageListView.setOnItemClickListener { _, _, position, _ ->
                val selectedLanguage = languages[position]
                val selectedLocale=locales[position]
                setLocale(selectedLocale)

                // Update TextView with localized text
                textview.text = getString(R.string.come_to_home)

                // Show a toast confirming language change
                Toast.makeText(this, "Language changed to: $selectedLanguage", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            // Show the dialog
            dialog.show()
        }
    }
    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = resources.configuration
        config.setLocale(locale)

        // Check for Android Nougat (API 24) and above
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            val context = createConfigurationContext(config)
            applyOverrideConfiguration(config)  // Apply the new configuration
        } else {
            // For devices below Android 7.0
            @Suppress("DEPRECATION")
            resources.updateConfiguration(config, resources.displayMetrics)
        }

        // Restart the activity to apply the language change
        recreate()
    }


}