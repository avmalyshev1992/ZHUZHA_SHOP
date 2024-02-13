package com.example.zhuzha_shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zhuzha_shop.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var detailBinding: FragmentDetailsBinding? = null
    private val binding get() = detailBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFoodsDetails()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        detailBinding = null
    }


    private fun setFoodsDetails() {
        //Получаем наш фильм из переданного бандла
        val food = arguments?.get("food") as Food


        //Устанавливаем заголовок
        detailBinding?.detailsToolbar?.title = food.title
        //Устанавливаем картинку
        detailBinding?.detailsPoster?.setImageResource(food.picture)
        //Устанавливаем описание
        detailBinding?.detailsDescription?.text = food.description

        detailBinding?.detailsFabFavorites?.setImageResource(
            if (food.isInFavorites) R.drawable.baseline_favorite_24
            else R.drawable.baseline_favorite_border_24
        )
    }




}