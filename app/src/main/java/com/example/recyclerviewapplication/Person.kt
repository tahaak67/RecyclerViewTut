package com.example.recyclerviewapplication

import androidx.annotation.DrawableRes

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 02,Feb,2023
 */
data class Person(
    val name: String,
   @DrawableRes val imageUrl: Int
)
