package com.example.zhuzha_shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zhuzha_shop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        initNavigation()


        //Запускаем фрагмент при старте
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()


        fun launchDetailsFragment(shelf: Shelf) {
            //Создаем "посылку"
            val bundle = Bundle()
            //Кладем наш фильм в "посылку"
            bundle.putParcelable("shelf", shelf)
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


      /*  //находим наш RV
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

*/
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
