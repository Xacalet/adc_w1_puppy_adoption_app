package com.xacalet.bffinder.data

data class Dog(
    val id: Long,
    val name: String,
    val gender: String,
    val months: Int,
    val breed: String,
    val description: String,
    val picUrl: String,
    var isBff: Boolean
)