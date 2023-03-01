package com.example.tokosmartphome

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewProduct: RecyclerView
    private val list = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewProduct = findViewById(R.id.view_card)
        viewProduct.setHasFixedSize(true)

        list.addAll(listProduct)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentAbout = Intent(this@MainActivity, About::class.java)
        startActivity(intentAbout)
        return super.onOptionsItemSelected(item)
    }

    private val listProduct: ArrayList<Product>
        @SuppressLint("Recycle")
        get() {
            val dataName = resources.getStringArray(R.array.name_product)
            val dataPrice = resources.getStringArray(R.array.price_product)
            val dataDesc = resources.getStringArray(R.array.desc_product)
            val dataScreen = resources.getStringArray(R.array.screen_product)
            val dataCamera = resources.getStringArray(R.array.camera_product)
            val dataRam = resources.getStringArray(R.array.ram_product)
            val dataWeight = resources.getStringArray(R.array.weight_product)
            val dataMemory = resources.getStringArray(R.array.memory_product)
            val dataColor = resources.getStringArray(R.array.color_product)
            val dataImage = resources.obtainTypedArray(R.array.img_product)
            val listProduct =ArrayList<Product>()
            for(i in dataName.indices){
                val product = Product(dataName[i], dataPrice[i], dataImage.getResourceId(i, -1), dataDesc[i], dataScreen[i], dataCamera[i], dataRam[i], dataWeight[i], dataMemory[i], dataColor[i])
                listProduct.add(product)
            }
            return listProduct
        }

    private fun showRecyclerList() {
        viewProduct.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListProductAdapter(list)
        viewProduct.adapter = listHeroAdapter
    }
}