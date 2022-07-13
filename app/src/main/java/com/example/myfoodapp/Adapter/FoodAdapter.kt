package com.example.myfoodapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.Food
import com.example.myfoodapp.R

class FoodAdapter(private val foodList: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    var onItemClick : ((Food) -> Unit)? = null

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val showName = itemView.findViewById<TextView>(R.id.food_name)
        val showDesc = itemView.findViewById<TextView>(R.id.food_desc)
        val showPrice = itemView.findViewById<TextView>(R.id.food_price)
        val showPict = itemView.findViewById<ImageView>(R.id.img_food)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.showName.text = food.name
        holder.showDesc.text = food.desc
        holder.showPrice.text = food.price
        holder.showPict.setImageResource(food.image)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(food)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

}