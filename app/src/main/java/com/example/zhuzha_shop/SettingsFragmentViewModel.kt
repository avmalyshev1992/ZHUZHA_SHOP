package com.example.zhuzha_shop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SettingsFragmentViewModel : ViewModel() {

    @Inject
    lateinit var interactor: Interactor
    val categoryPropertyLifeData: MutableLiveData<String> = MutableLiveData()

    fun putCategoryProperty(category: String) {

    }
}