package com.example.popup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var t1=findViewById<TextView>(R.id.t1)
        var t2=findViewById<TextView>(R.id.t2)
        var t3=findViewById<TextView>(R.id.t3)
        var t4=findViewById<TextView>(R.id.t4)
        var t5=findViewById<TextView>(R.id.t5)

        var btn=findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            var b=AlertDialog.Builder(this)
            b.setTitle("Delete")
            b.setMessage("Do you really want to Delete?")
            b.setCancelable(false)
            b.setPositiveButton("Yes"){dialog,_->t1.visibility=android.view.View.GONE}
            b.setNegativeButton("No"){dialog,_->dialog.dismiss()}
            b.create()
            b.show()
        }



//        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)













//        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
//            Toast.makeText(this, "You rated: $rating stars", Toast.LENGTH_SHORT).show()
//        }
    }

}