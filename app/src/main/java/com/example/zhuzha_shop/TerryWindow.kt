package com.example.zhuzha_shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zhuzha_shop.databinding.ActivityTerryWindowBinding

class TerryWindow : AppCompatActivity() {
    private var binding: ActivityTerryWindowBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerryWindowBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //Запускаем фрагмент при старте
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()

    }


        fun launchDetailsFragment(food: Food) {
            //Создаем "посылку"
            val bundle = Bundle()
            //Кладем наш фильм в "посылку"
            bundle.putParcelable("food", food)
            //Кладем фрагмент с деталями в перменную
            val fragment = DetailsFragment()
            //Прикрепляем нашу "посылку" к фрагменту
            fragment.arguments = bundle

            //Запускаем фрагмент
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_placeholder, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
