package com.xacalet.bffinder.data

data class Dog(
    val name: String,
    val gender: String,
    val months: Int,
    val breed: String,
    val picUrl: String,
    var isBff: Boolean
)