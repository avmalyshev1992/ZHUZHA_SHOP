package com.example.zhuzha_shop

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zhuzha_shop.databinding.ShelfItemBinding

class ShelfViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    val filmBinding = ShelfItemBinding.bind(itemView)

    fun bind(shelf: Shelf) {

        // заголовок
        filmBinding.title.text = shelf.title
        // картинка
        filmBinding.picture.setImageResource(shelf.picture)
        // описание
        filmBinding.description.text = shelf.description
    }

}