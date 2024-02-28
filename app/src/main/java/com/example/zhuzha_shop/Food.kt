package com.example.zhuzha_shop


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cached_films", indices = [Index(value = ["title"], unique = true)])
data class Food (
    val title: String,
    val picture: Int,
    val description: String,
    var isInFavorites: Boolean = false

) : Parcelable