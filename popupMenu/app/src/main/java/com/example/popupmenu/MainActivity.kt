package com.example.popupmenu

import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            val popupMenu = PopupMenu(this, button)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.option1 -> {
                        Toast.makeText(this, "Option 1 Selected", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.option2 -> {
                        Toast.makeText(this, "Option 2 Selected", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.option3 -> {
                        Toast.makeText(this, "Option 3 Selected", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }

            popupMenu.show()
        }
    }
}