package com.example.zhuzha_shop

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zhuzha_shop.databinding.FoodItemBinding


class FoodViewHolder (private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем View из layout к переменным
    val foodBinding = FoodItemBinding.bind(itemView)


    fun bind(food: Food) {

        // заголовок
        foodBinding.title.text = food.title
        // картинка
        foodBinding.picture.setImageResource(food.picture)
        // описание
        foodBinding.description.text = food.description
    }
}