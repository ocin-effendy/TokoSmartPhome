package com.example.tokosmartphome

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String,
    val price: String,
    val image: Int,
    val desc: String,
    val screen: String,
    val camera: String,
    val ram: String,
    val weight: String,
    val memory: String,
    val color: String,
) : Parcelable