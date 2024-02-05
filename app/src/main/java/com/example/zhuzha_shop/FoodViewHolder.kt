package com.example.zhuzha_shop

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zhuzha_shop.databinding.FoodItemBinding


class FoodViewHolder (private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем View из layout к переменным
    val foodBinding = FoodItemBinding.bind(itemView)


    fun bind(food: Food) {

        // заголовок
        foodBinding.titleF.text = food.titleF
        // картинка
        foodBinding.pictureF.setImageResource(food.pictureF)
        // описание
        foodBinding.descriptionF.text = food.descriptionF
    }
}