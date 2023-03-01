package com.example.tokosmartphome

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailProduct : AppCompatActivity() {
    private lateinit var imageHero: ImageView
    private lateinit var name: TextView
    private lateinit var price: TextView
    private lateinit var desc: TextView
    private lateinit var screen: TextView
    private lateinit var camera: TextView
    private lateinit var ram: TextView
    private lateinit var weight: TextView
    private lateinit var memory: TextView
    private lateinit var color: TextView

    companion object {
        const val DATA_PRODUCT = "DATA_PRODUCT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageHero = findViewById(R.id.heroImage)
        name = findViewById(R.id.name)
        price = findViewById(R.id.price)
        desc = findViewById(R.id.desc)
        screen = findViewById(R.id.screen)
        camera = findViewById(R.id.camera)
        ram = findViewById(R.id.ram)
        weight = findViewById(R.id.weight)
        memory = findViewById(R.id.memory)
        color = findViewById(R.id.color)

        val product = if(Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(DATA_PRODUCT, Product::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(DATA_PRODUCT)
        }

        if(product != null){
            imageHero.setImageResource(product.image)
            name.text = product.name
            price.text = product.price
            desc.text = product.desc
            screen.text = product.screen
            camera.text = product.camera
            ram.text = product.ram
            weight.text = product.weight
            memory.text = product.memory
            color.text = product.color
        }

    }
}