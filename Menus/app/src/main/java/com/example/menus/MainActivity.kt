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
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val destinationSpinner: Spinner =findViewById(R.id.spinner)
        val packageListView:ListView=findViewById(R.id.list1)
        val destinations= arrayOf("Paris","New York","Tokyo")
        val parisDes= arrayOf("Effiel Tower","Louvre Museum")
        val newYorkDes= arrayOf("Statue of Liberty","Central Park")
        val TokyoDes= arrayOf("Mount Fuji","Tokyo Tower","Senso-ji Temple")

        val spinnerAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,destinations)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        destinationSpinner.adapter=spinnerAdapter

        val initialAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,parisDes)
        packageListView.adapter=initialAdapter

        destinationSpinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int,id:Long) {
                val selectedPackages=when(position){
                    0 ->parisDes
                    1->newYorkDes
                    else ->TokyoDes
                }

                val listAdapter=ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,selectedPackages)
                packageListView.adapter=listAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }
}