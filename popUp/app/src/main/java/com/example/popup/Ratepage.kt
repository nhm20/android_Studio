package com.example.popup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Ratepage: AppCompatActivity()  {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.rate_page)
        val btn = findViewById<Button>(R.id.btn)
//        val rate = findViewById<Button>(R.id.rate)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        // Show the popup dialog
        btn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Exit")
            builder.setMessage("Do you really want to exit?")
            builder.setCancelable(false)
            builder.setPositiveButton("Yes") { _, _ -> finish() }
            builder.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            builder.setNeutralButton("Maybe") { _, _ ->
                Toast.makeText(this, "You clicked Maybe", Toast.LENGTH_SHORT).show()
            }
            builder.create().show()
        }

        // Navigate to Ratepage
        rate.setOnClickListener {
            val intent = Intent(this, Ratepage::class.java)
            startActivity(intent)
        }

        // Handle RatingBar changes
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(this, "You rated: $rating stars", Toast.LENGTH_SHORT).show()
        }
    }
}