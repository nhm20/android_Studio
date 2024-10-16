package com.example.snackbarproject

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var btn=findViewById<ImageButton>(R.id.btn)
        var btn2=findViewById<ImageButton>(R.id.btn2)
        var btn3=findViewById<ImageButton>(R.id.btn3)
        var btn4=findViewById<ImageButton>(R.id.btn4)
        var btn5=findViewById<ImageButton>(R.id.btn5)
        var btn6=findViewById<ImageButton>(R.id.btn6)
        var btn7=findViewById<ImageButton>(R.id.btn7)
        var btn8=findViewById<ImageButton>(R.id.btn8)
        var btn9=findViewById<ImageButton>(R.id.btn9)

        btn.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of CSE!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"SCSE Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn2.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of CE!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"SCE Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn3.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of Law!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"SLaw Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn4.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of Agriculture!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"SAgri Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn5.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of Architecture!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"SArchi Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn6.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of Fashion!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"SFashion Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn7.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of ECE!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"SECE Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn8.setOnClickListener{
                view->
            Snackbar.make(view,"Welcome to School of Polytechnic!", Snackbar.LENGTH_LONG).setAction("add"){
                Toast.makeText(this,"School of Polytechnic Added", Toast.LENGTH_LONG).show()
            }.show()
        }
        btn9.setOnClickListener { view ->
            val parentLayout = findViewById<CoordinatorLayout>(R.id.coordinator_layout)  // Replace with the ID of your CoordinatorLayout
            val snackbar = Snackbar.make(parentLayout, "Welcome to School of ME!", Snackbar.LENGTH_LONG)
                .setAction("add") {
                    Toast.makeText(this, "School of ME Added", Toast.LENGTH_LONG).show()
                }

            // Optional: Add callback for swipe event
            snackbar.addCallback(object : Snackbar.Callback() {
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    if (event == Snackbar.Callback.DISMISS_EVENT_SWIPE) {
                        Toast.makeText(this@MainActivity, "Snackbar swiped away!", Toast.LENGTH_SHORT).show()
                    }
                }
            })

            snackbar.show()  // Show the Snackbar
        }





    }
}