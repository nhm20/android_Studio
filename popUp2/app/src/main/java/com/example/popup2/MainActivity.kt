package com.example.popup2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
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
        var subbtn=findViewById<Button>(R.id.btn)
        subbtn.setOnClickListener{
            var customDialog=LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
            var g=AlertDialog.Builder(this).setView(customDialog)
            g.setPositiveButton("Subscribe"){dialog,_->
                val edText=customDialog.findViewById<EditText>(R.id.emailId)
                val email=edText.text.toString()
                if(email.isNotBlank()){
                    Toast.makeText(this,"subscribed with $email",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"enter valid email",Toast.LENGTH_LONG).show()
                }
                dialog.dismiss()
            }
            g.setNegativeButton("cancel"){dialog,_->dialog.dismiss()}
            g.create().show()
        }

    }
}