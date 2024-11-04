package com.example.popup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Ratepage: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.rate_page)
        var btn=findViewById<RatingBar>(R.id.ratingBar)
        btn.setOnClickListener{
            var b= AlertDialog.Builder(this)
//            b.setIcon(@)
            b.setTitle("Exit")
            b.setMessage("Do you really want to exit?")
            b.setCancelable(false)
            b.setPositiveButton("Yes"){dialog,_->finish()}
            b.setNegativeButton("No"){dialog,_->dialog.dismiss()}
            b.setNeutralButton("May be"){dialog,_-> Toast.makeText(this,"May be clicked", Toast.LENGTH_LONG).show()}
            b.create()
            b.show()
        }
        rate.setOnClickListener{
            var i= Intent(this,Ratepage::class.java)
            startActivity(i)

        }
    }
}