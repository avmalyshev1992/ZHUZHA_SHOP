package com.example.zhuzha_shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.zhuzha_shop.databinding.ActivityTwoWindowBinding

class TwoWindow : AppCompatActivity() {
    private var binding: ActivityTwoWindowBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoWindowBinding.inflate(layoutInflater)
        setContentView(binding!!.root)



        val link = "https://cataas.com/cat"
        Glide.with(this)
            .load(R.drawable.ic_launcher_foreground)
            .into(binding!!.cats)


    }

}