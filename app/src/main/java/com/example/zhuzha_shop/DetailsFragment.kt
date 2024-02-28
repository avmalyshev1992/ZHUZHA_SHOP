package com.example.zhuzha_shop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zhuzha_shop.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var detailBinding: FragmentDetailsBinding? = null
    private val binding get() = detailBinding!!
    private lateinit var food: Food

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

        detailBinding?.detailsFabFavorites?.setOnClickListener {
            if (!food.isInFavorites) {
                detailBinding?.detailsFabFavorites?.setImageResource(R.drawable.baseline_favorite_24)
                food.isInFavorites = true
            } else {
                detailBinding?.detailsFabFavorites?.setImageResource(R.drawable.baseline_favorite_border_24)
                food.isInFavorites = false
            }
        }

        detailBinding?.detailsFabShare!!.setOnClickListener {
            //Создаем интент
            val intent = Intent()
            //Укзываем action с которым он запускается
            intent.action = Intent.ACTION_SEND
            //Кладем данные о нашем фильме
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this food: ${food.title} \n\n ${food.description}"
            )
            //УКазываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }

        binding.detailsFabWatchLater.setOnClickListener {
            NotificationHelper.createNotification(requireContext(), food)
        }
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