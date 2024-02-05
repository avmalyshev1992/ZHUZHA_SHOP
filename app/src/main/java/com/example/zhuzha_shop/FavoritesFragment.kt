package com.example.zhuzha_shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zhuzha_shop.databinding.FragmentFavoritesBinding


class FavoritesFragment : Fragment() {

    private lateinit var foodsAdapter: FoodListRecyclerAdapter
    private var favBinding: FragmentFavoritesBinding? = null
    private val binding
        get() = favBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        favBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Получаем список при транзакции фрагмента
        val favoritesList: List<Food> = emptyList()
    }


}