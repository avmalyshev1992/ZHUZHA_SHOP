package com.example.zhuzha_shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FoodListRecyclerAdapter(private val clickListener: OnItemClickListenerf) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //Здесь у нас хранится список элементов для RV
    private val itemsf = mutableListOf<Food>()

    //Этот метод нужно переопределить на возврат количества элементов в списке RV
    override fun getItemCount() = itemsf.size

    //В этом методе мы привязываем наш ViewHolder и передаем туда "надутую" верстку нашего фильма
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false))
    }

    //В этом методе будет привязка полей из объекта Film к View из film_item.xml
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //Проверяем, какой у нас ViewHolder
        when (holder) {
            is FoodViewHolder -> {
                //Вызываем метод bind(), который мы создали, и передаем туда объект
                //из нашей базы данных с указанием позиции
                holder.bind(itemsf[position])
                //Обрабатываем нажатие на весь элемент целиком(можно сделать на отдельный элемент
                //например, картинку) и вызываем метод нашего листенера, который мы получаем из
                //конструктора адаптера
                holder.foodBinding.itemContainerfood.setOnClickListener {
                    clickListener.clickf(itemsf[position])
                }
            }
        }
    }
    //Метод для добавления объектов в наш список
    fun addItemsf(list: List<Food>) {
        //Сначала очищаем(если не реализовать DiffUtils)
        itemsf.clear()
        //Добавляем
        itemsf.addAll(list)
        //Уведомляем RV, что пришел новый список, и ему нужно заново все "привязывать"
        notifyDataSetChanged()
    }


    //Интерфейс для обработки кликов
    interface OnItemClickListenerf {
        fun clickf(food: Food)
    }
}