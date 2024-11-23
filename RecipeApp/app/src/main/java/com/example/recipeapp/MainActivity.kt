package com.example.recipeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the toolbar as the action bar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val mealLayout: LinearLayout = findViewById(R.id.lybtn)
        val lunchLayout: LinearLayout = findViewById(R.id.lybtn2)
        val snackLayout: LinearLayout = findViewById(R.id.lybtn3)
        val dinnerLayout: LinearLayout = findViewById(R.id.lybtn4)

        mealLayout.setOnClickListener {
            showMealPopup(it)
        }

        lunchLayout.setOnClickListener {
            showMealPopup(it)
        }
        snackLayout.setOnClickListener {
            showMealPopup(it)
        }
        dinnerLayout.setOnClickListener {
            showMealPopup(it)
        }
    }

    // Inflate the menu in the action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)
        return true
    }

    // Handle item selection in the action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.i1 -> {
                // Handle "Get Idea" action
                true
            }
            R.id.i2 -> {
                // Handle "Recipe of the Day" action
                true
            }
            R.id.i3 -> {
                // Handle "Popular" action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showMealPopup(view: View) {
        // Create a PopupMenu
        val popupMenu = PopupMenu(this, view)

        // Inflate the menu items
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.pop_menu, popupMenu.menu)

        // Loop through each item in the menu and modify the view
        for (i in 0 until popupMenu.menu.size()) {
            val menuItem = popupMenu.menu.getItem(i)

            // Create a custom view for the menu item
            val itemView = layoutInflater.inflate(R.layout.popup_menu_item, null)
            val imageView: ImageView = itemView.findViewById(R.id.menu_item_image)
            val textView: TextView = itemView.findViewById(R.id.menu_item_text)

            // Set the appropriate image and text for each menu item
            when (menuItem.itemId) {
                R.id.it -> {
                    imageView.setImageResource(R.drawable.img_4)
                    textView.text = "Idly"
                }
                R.id.it2 -> {
                    imageView.setImageResource(R.drawable.img_5)
                    textView.text = "Puri"
                }
                R.id.it3 -> {
                    imageView.setImageResource(R.drawable.img_6)
                    textView.text = "Dosa"
                }
            }

            // Set the custom view for this menu item
            menuItem.actionView = itemView
        }

        // Set a listener for when the menu item is clicked
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.it -> {
                    navigateToFoodPage("Idly", "A delicious steamed rice cake.", "$5.99", R.drawable.img_4)
                    true
                }
                R.id.it2 -> {
                    navigateToFoodPage("Puri", "A crispy deep-fried bread served with curry.", "$6.99", R.drawable.img_5)
                    true
                }
                R.id.it3 -> {
                    navigateToFoodPage("Dosa", "A thin, crispy pancake made from rice flour.", "$7.99", R.drawable.img_6)
                    true
                }
                else -> false
            }
        }

        // Show the popup menu
        popupMenu.show()
    }


    private fun navigateToFoodPage(foodName: String, description: String, price: String, imageRes: Int) {
        // Create an Intent to navigate to FoodPageActivity
        val intent = Intent(this, FoodPageActivity::class.java)
        intent.putExtra("FOOD_NAME", foodName)
        intent.putExtra("FOOD_DESCRIPTION", description)
        intent.putExtra("FOOD_PRICE", price)
        intent.putExtra("FOOD_IMAGE", imageRes)
        startActivity(intent)
    }
}