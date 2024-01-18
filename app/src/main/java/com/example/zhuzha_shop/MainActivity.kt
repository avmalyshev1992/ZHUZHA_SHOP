package com.example.zhuzha_shop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zhuzha_shop.databinding.ActivityMainBinding
import com.example.zhuzha_shop.databinding.ActivityTerryWindowBinding
import com.example.zhuzha_shop.databinding.ActivityTwoWindowBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding?.bottomNavigation?.setOnClickListener(){
            R.id.sale
            startActivity(Intent(this, ActivityTerryWindowBinding::class.java))

            R.id.selections
            startActivity(Intent(this, ActivityTwoWindowBinding::class.java))

            R.id.home
            startActivity(Intent(this, ActivityMainBinding::class.java))

        }

    }


}
