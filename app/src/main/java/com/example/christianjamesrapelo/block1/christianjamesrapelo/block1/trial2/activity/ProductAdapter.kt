package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.R
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.Products

class ProductAdapter(private var products: List<Products>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val productNameTextView: TextView = itemView.findViewById(R.id.textViewProductName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun updateData(newProducts: List<Products>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productNameTextView.text = product.title
    }
}