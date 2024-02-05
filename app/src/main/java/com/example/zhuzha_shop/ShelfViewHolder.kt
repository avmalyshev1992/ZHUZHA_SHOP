package com.example.zhuzha_shop

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zhuzha_shop.databinding.ShelfItemBinding

class ShelfViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем View из layout к переменным
    val shelfBinding = ShelfItemBinding.bind(itemView)

    fun bind(shelf: Shelf) {

        // заголовок
        shelfBinding.title.text = shelf.title
        // картинка
        shelfBinding.picture.setImageResource(shelf.picture)
        // описание
        shelfBinding.description.text = shelf.description
    }
}