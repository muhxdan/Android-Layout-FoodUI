package com.example.myfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.Adapter.FoodAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList : ArrayList<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodName = arrayOf("Special Pizza", "Special Dimsum")
        val foodDesc = arrayOf("With tommato sauce", "With meat filling")
        val foodPrice = arrayOf("\$12.50 ", "\$8.95")
        val foodPict = arrayOf(R.drawable.pizza, R.drawable.dimsum)

        recyclerView = findViewById(R.id.rv_food)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        foodList = ArrayList()

        for (item in foodName.indices)
            foodList.add(Food(foodPict[item], foodName[item], foodDesc[item], foodPrice[item], ))

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter


        adapter.onItemClick = {
            val intent = Intent(this, DetailFood::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }
    }

}