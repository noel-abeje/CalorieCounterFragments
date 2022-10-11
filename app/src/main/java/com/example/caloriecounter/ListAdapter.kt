package com.example.roomapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriecounter.Calories
import com.example.caloriecounter.R
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var foodList = emptyList<Calories>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.itemView.food.text = currentItem.foodItem
        holder.itemView.calories.text = currentItem.calories.toString()
    }

    fun setData(food: List<Calories>){
        this.foodList = food
        notifyDataSetChanged()
    }
}