package com.example.contextmenu

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var j1=findViewById<ImageView>(R.id.imageView)
        registerForContextMenu(j1)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val j2:MenuInflater=menuInflater
        j2.inflate(R.menu.context_menu,menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        var j3=findViewById<ImageView>(R.id.imageView)
        return when(item.itemId) {
            R.id.changeColor -> {
                j3.setColorFilter(Color.RED)
                Toast.makeText(this, "Image color changed to red", Toast.LENGTH_LONG).show()
                true
            }
            R.id.rotate->{
                j3.rotation=j3.rotation+45f
                Toast.makeText(this, "Image rotated to 45 degrees", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}

















