package com.example.zhuzha_shop

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shelf(
    val title: String,
    val picture: Int,
    val description: String
) : Parcelable
