package com.example.bouquet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.sbm)
        var name = findViewById<EditText>(R.id.name)
        var pass = findViewById<EditText>(R.id.pass)
        btn.setOnClickListener {
            var a = name.text.toString()
            var b = pass.text.toString()
            val i = Intent(this, HomePage::class.java)
            i.putExtra("name", a)
            i.putExtra("pass", b)
            startActivity(i)
        }
    }
}