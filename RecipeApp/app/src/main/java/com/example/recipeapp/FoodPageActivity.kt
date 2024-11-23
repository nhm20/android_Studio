package com.example.recipeapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FoodPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_activity)

        // Get the food name from the Intent
        val foodName = intent.getStringExtra("FOOD_NAME")
        val foodDescription = intent.getStringExtra("FOOD_DESCRIPTION")
        val foodPrice = intent.getStringExtra("FOOD_PRICE")
        val foodImageRes = intent.getIntExtra("FOOD_IMAGE", 0)

        // Bind data to views
        val nameTextView: TextView = findViewById(R.id.food_name)
        val descriptionTextView: TextView = findViewById(R.id.food_description)
        val priceTextView: TextView = findViewById(R.id.food_price)
        val foodImageView: ImageView = findViewById(R.id.food_image)

        nameTextView.text = foodName
        descriptionTextView.text = foodDescription
        priceTextView.text = foodPrice
        foodImageView.setImageResource(foodImageRes)
    }
}