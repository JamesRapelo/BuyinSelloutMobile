package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.R
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.FeaturedProductApi
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.FeaturedProducts


class FeaturedProductAdapter(private var products: List<FeaturedProducts>): RecyclerView.Adapter<FeaturedProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val productTitleTextView: TextView = itemView.findViewById(R.id.textViewProductTitle)
//        val productDescriptionTextView: TextView = itemView.findViewById(R.id.textViewProductDescription)
        val productPriceTextView: TextView = itemView.findViewById(R.id.textViewProductPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_featured_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun updateData(newProducts: List<FeaturedProducts>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productTitleTextView.text = "Title: \n ${product.title}"
//        holder.productDescriptionTextView.text = product.description
        holder.productPriceTextView.text = "Price: \n ${product.price}"

    }
}