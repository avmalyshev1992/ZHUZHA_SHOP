package com.example.zhuzha_shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhuzha_shop.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var bindingFrag: FragmentHomeBinding? = null
    private val binding1 get() = bindingFrag!!

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFrag = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding1.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingFrag = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //находим наш RV
        bindingFrag?.mainRecycler?.apply {
            foodAdapter = FoodListRecyclerAdapter(object : FoodListRecyclerAdapter.OnItemClickListener{
                override fun click(food: Food) {
                    (requireActivity() as TerryWindow).launchDetailsFragment(food)
                }
            })
            //Присваиваем адаптер
            adapter = foodAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        foodAdapter.addItems(foodDataBase)
    }
}