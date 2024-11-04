package com.example.demo

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GridLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_layout)
        var a=findViewById<ImageButton>(R.id.imageButton4)
        a.setOnClickListener{
            Toast.makeText(this,"Image View Button Clicked", Toast.LENGTH_LONG).show();
        }
    }
}
