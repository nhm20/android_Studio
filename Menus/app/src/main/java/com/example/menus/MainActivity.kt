package com.example.menus

import android.annotation.SuppressLint
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity :AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val packageListView: ListView = findViewById(R.id.list1)
        val parisDes = arrayOf("GO to market", "Do Work")

        val initialAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, parisDes)
        packageListView.adapter = initialAdapter

        packageListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> {
                    val b = AlertDialog.Builder(this@MainActivity)
                    b.setTitle("Delete")
                    b.setMessage("Do you really want to Delete?")
                    b.setCancelable(false)
                    b.setPositiveButton("Yes") { dialog, _ ->
                        view?.visibility = View.GONE
                    }
                    b.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
                    b.create()
                    b.show()
                }
                else -> {
                    false
                }
            }
        }
    }
}