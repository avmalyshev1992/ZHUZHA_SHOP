package com.example.zhuzha_shop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhuzha_shop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var shelfsAdapter: ShelfListRecyclerAdapter



    val shelfDataBase = listOf(
        Shelf("Корм",R.drawable.eda, "Еда для котиков" ),
        Shelf("Удобный сон", R.drawable.lezhanka, "Каждому котику по комфортной лежаночке"),
        Shelf("Лоточки Совочки", R.drawable.lotok, "Делай грязные дела в чистоте"),
        Shelf("Аксессуары", R.drawable.osheynik, "Украшением котика хуже не сделаешь"),
        Shelf("Когтеточки", R.drawable.tochilka, "Купил когтеточку, спас диван"),
        Shelf("Игрушки", R.drawable.toys, "Чем меньше у котика игрушек, тем больше Ваших вещей стемятся упасть с полки"),
        Shelf("Витамины", R.drawable.vitamini, "В доме, где нет витаминов, есть много шерсти под диваном")

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        initNavigation()




        //находим наш RV
        binding?.mainRecycler.apply {
            shelfsAdapter = ShelfListRecyclerAdapter(object : ShelfListRecyclerAdapter.OnItemClickListener{
                override fun click(shelf: Shelf) {
                    //Запускаем наше активити
                    val intent = Intent(this@MainActivity, TerryWindow::class.java)
                    startActivity(intent)
                }
            })
            //Присваиваем адаптер
            this!!.adapter = shelfsAdapter
            //Присвои layoutmanager
            this!!.layoutManager = LinearLayoutManager(this@MainActivity)
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            this!!.addItemDecoration(decorator)
        }

//Кладем нашу БД в RV
        shelfsAdapter.addItems(shelfDataBase)

            binding?.btnCats?.setOnClickListener {
                // Создание Intent для перехода к другой активити
                val intent = Intent(this, TwoWindow::class.java)
                startActivity(intent)
            }


    }
    private fun initNavigation() {


        binding?.bottomNavigation?.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(androidx.fragment.R.id.fragment_container_view_tag, FavoritesFragment())
                        .addToBackStack(null)
                        .commit()
                    true

                }
                else -> false
            }

        }
    }
}
