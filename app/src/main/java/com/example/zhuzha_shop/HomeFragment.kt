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
            shelfsAdapter = ShelfListRecyclerAdapter(object : ShelfListRecyclerAdapter.OnItemClickListener{
                override fun click(shelf: Shelf) {
                    (requireActivity() as MainActivity).launchDetailsFragment(shelf)
                }
            })
            //Присваиваем адаптер
            adapter = shelfsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        shelfsAdapter.addItems(shelfDataBase)
    }
}
