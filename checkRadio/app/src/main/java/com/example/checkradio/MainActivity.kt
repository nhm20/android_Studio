package com.example.checkradio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var a = findViewById<RadioGroup>(R.id.pizzaTypeRadioGroup)
        var b = findViewById<RadioButton>(R.id.pepperoniRadioButton)
        var c = findViewById<RadioButton>(R.id.margheritaRadioButton)


        var d = findViewById<RadioButton>(R.id.fourSeasonRadioButton)
        var e = findViewById<RadioGroup>(R.id.sizeRadioGroup)
        var f = findViewById<RadioButton>(R.id.regularRadioButton)
        var g = findViewById<RadioButton>(R.id.mediumRadioButton)
        var i = findViewById<RadioButton>(R.id.largeRadioButton)
        var j = findViewById<CheckBox>(R.id.onionsCheckBox)
        var k = findViewById<CheckBox>(R.id.blackOlivesCheckBox)
        var l = findViewById<CheckBox>(R.id.extraCheeseCheckBox)
        var m = findViewById<CheckBox>(R.id.sausageCheckBox)


        var submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            // Get the selected pizza type
            val selectedPizzaType = when (a.checkedRadioButtonId) {
                b.id -> "Pepperoni"
                c.id -> "Margherita"
                d.id -> "Four Season"
                else -> "No selection"
            }
            // Get the selected pizza size
            val selectedSize = when (e.checkedRadioButtonId) {
                f.id -> "Regular"
                g.id -> "Medium"
                i.id -> "Large"
                else -> "No selection"
            }

            // Get the selected toppings
            val selectedToppings = mutableListOf<String>()
            if (j.isChecked) selectedToppings.add("Onions")
            if (k.isChecked) selectedToppings.add("Black Olives")
            if (l.isChecked) selectedToppings.add("Extra Cheese")
            if (m.isChecked) selectedToppings.add("Sausage")

            // Display the selections (or perform further actions)
            val orderSummary = "Pizza Type: $selectedPizzaType\nSize: $selectedSize\nToppings: ${selectedToppings.joinToString(", ")}"
            Toast.makeText(this, orderSummary, Toast.LENGTH_LONG).show()
        }


    }
}