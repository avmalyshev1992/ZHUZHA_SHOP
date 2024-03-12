package com.example.zhuzha_shop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zhuzha_shop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)



        initNavigation()



        binding?.btnCats?.setOnClickListener {
                // Создание Intent для перехода к другой активити
                val intent = Intent(this, TwoWindow::class.java)
                startActivity(intent)
            }

        binding?.btnFood?.setOnClickListener{
            // Создание Intent для перехода к другой активити
            val intent = Intent(this, TerryWindow::class.java)
            startActivity(intent)
        }

        binding?.btnLotok?.setOnClickListener {
            Toast.makeText(this, "Пока в разработке", Toast.LENGTH_SHORT).show()
        }

        binding?.btnToys?.setOnClickListener {
            Toast.makeText(this, "Пока в разработке", Toast.LENGTH_SHORT).show()
        }

        binding?.btnLezhanka?.setOnClickListener {
            Toast.makeText(this, "Пока в разработке", Toast.LENGTH_SHORT).show()
        }

        binding?.btnTochilka?.setOnClickListener {
            Toast.makeText(this, "Пока в разработке", Toast.LENGTH_SHORT).show()
        }

        binding?.btnVitamini?.setOnClickListener {
            Toast.makeText(this, "Пока в разработке", Toast.LENGTH_SHORT).show()
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
