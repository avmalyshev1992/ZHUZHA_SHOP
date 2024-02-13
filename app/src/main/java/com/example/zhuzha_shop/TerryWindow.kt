package com.example.zhuzha_shop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhuzha_shop.databinding.ActivityTerryWindowBinding

class TerryWindow : AppCompatActivity() {
    private var binding: ActivityTerryWindowBinding? = null
    private lateinit var foodAdapter: FoodListRecyclerAdapter


    val foodDataBase = listOf(

        Food("Royal Canin", R.drawable.royal, "Жидкий корм для котиков"),
        Food("Perfect Fit", R.drawable.perfect,"Жидкий корм для котиков"),
        Food("Sheba", R.drawable.sheba, "Жидкий корм для котиков"),
        Food("Наша Марка", R.drawable.hm, "Жидкий корм для котиков"),
        Food("Felix", R.drawable.felix, "Жидкий корм для котиков"),
        Food("Friskies", R.drawable.friskies, "Жидкий корм для котиков"),
        Food("Kitekat", R.drawable.kitekat, "Жидкий корм для котиков"),
        Food("Whiskas", R.drawable.whiskas, "Жидкий корм для котиков")

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerryWindowBinding.inflate(layoutInflater)
        setContentView(binding!!.root)



        //находим наш RV
        binding?.mainRecycler.apply {
            foodAdapter = FoodListRecyclerAdapter(object : FoodListRecyclerAdapter.OnItemClickListener{
                override fun click(food: Food) {
                    //Создаем бандл и кладем туда объект с данными фильма
                    val bundle = Bundle()
                    //Первым параметром указывается ключ, по которому потом будем искать, вторым сам
                    //передаваемый объект
                    bundle.putParcelable("food", food)
                    //Запускаем наше активити
                    val intent = Intent(this@TerryWindow, DetailsFragment::class.java)
                    //Прикрепляем бандл к интенту
                    intent.putExtras(bundle)
                    //Запускаем активити через интент
                    startActivity(intent)
                }
            })


            //Присваиваем адаптер
            this!!.adapter = foodAdapter
            //Присвои layoutmanager
            this!!.layoutManager = LinearLayoutManager(this@TerryWindow)
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            this!!.addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        foodAdapter.addItems(foodDataBase)
    }

}