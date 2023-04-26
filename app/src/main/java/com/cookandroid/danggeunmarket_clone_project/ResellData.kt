package com.cookandroid.danggeunmarket_clone_project

import android.graphics.drawable.Drawable

data class ResellData(
    var image: Drawable?,
    var title: String,
    var placeTime: String,
    val content: String,
    var cost: String?,
    var likeNum: Int
)
