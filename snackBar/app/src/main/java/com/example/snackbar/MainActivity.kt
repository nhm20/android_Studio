package com.example.snackbar

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            view->
            Snackbar.make(view,"This is a Snackbar!",Snackbar.LENGTH_LONG).setAction("undo"){
                Toast.makeText(this,"Undo was Clicked",Toast.LENGTH_LONG).show()
            }.show()
        }
    }
}