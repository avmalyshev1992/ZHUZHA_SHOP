package com.example.zhuzha_shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zhuzha_shop.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private var detailBinding: ActivityDetailsBinding? = null
    private lateinit var food: Food
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailBinding!!.root)

        setFoodsDetails()

        detailBinding?.detailsFabFavorites?.setOnClickListener {
            if (!food.isInFavorites) {
                detailBinding?.detailsFabFavorites?.setImageResource(R.drawable.baseline_favorite_24)
                food.isInFavorites = true
            } else {
                detailBinding?.detailsFabFavorites?.setImageResource(R.drawable.baseline_favorite_border_24)
                food.isInFavorites = false
            }
        }
    }


    private fun setFoodsDetails() {
        //Получаем наш фильм из переданного бандла
        val food = intent.extras?.get("food") as Food

        //Устанавливаем заголовок
        detailBinding?.detailsToolbar?.title = food.titleF
        //Устанавливаем картинку
        detailBinding?.detailsPoster?.setImageResource(food.pictureF)
        //Устанавливаем описание
        detailBinding?.detailsDescription?.text = food.descriptionF

        detailBinding?.detailsFabFavorites?.setImageResource(
            if (food.isInFavorites) R.drawable.baseline_favorite_24
            else R.drawable.baseline_favorite_border_24
        )
    }




}