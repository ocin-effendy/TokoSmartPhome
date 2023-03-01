package com.example.tokosmartphome

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListProductAdapter(private val listProduct: ArrayList<Product>) : RecyclerView.Adapter<ListProductAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct: ImageView = itemView.findViewById(R.id.img_item_photo)
        val nameProduct: TextView = itemView.findViewById(R.id.product_item_name)
        val priceProduct: TextView = itemView.findViewById(R.id.product_item_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_product,parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, price, image, desc, screen, camera, ram, weight, memory, color) = listProduct[position]
        holder.imgProduct.setImageResource(image)
        holder.nameProduct.text = name
        holder.priceProduct.text = price
        val product = Product(
            name, price, image, desc, screen, camera, ram, weight, memory, color
        )

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailProduct::class.java)
            intentDetail.putExtra(DetailProduct.DATA_PRODUCT, product)
            holder.itemView.context.startActivity(intentDetail)
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listProduct.size




}