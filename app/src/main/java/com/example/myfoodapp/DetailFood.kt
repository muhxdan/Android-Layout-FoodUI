package com.example.myfoodapp

import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_food)

        val food = intent.getParcelableExtra<Food>("food")

        if(food != null){
            val foodName: TextView = findViewById(R.id.textview14)
            val foodDesc: TextView = findViewById(R.id.textview15)
            val foodPict: ImageView = findViewById(R.id.img_full_food)

            foodName.text = food.name
            foodDesc.text = food.desc
            foodPict.setImageResource(food.image)
        }

    }
}