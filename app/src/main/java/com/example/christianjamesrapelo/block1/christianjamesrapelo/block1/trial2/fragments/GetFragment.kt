package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api.Api
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api.RetrofitClient
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.R
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.activity.LatestProductAdapter
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.LatestProductsApi
import kotlinx.coroutines.launch


class GetFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: LatestProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_get, container, false)

        recyclerView = view.findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

//        fetchProductsFromApi()

        return view
    }

//    private fun fetchProductsFromApi() {
//        val retrofit = RetrofitClient.getRetrofit()
//        val productsApi = retrofit.create(Api::class.java)
//
//        // Use CoroutineScope to launch a coroutine
//        lifecycleScope.launch {
//            try {
//                val products = productsApi.getProducts()
//                updateUI(products)
//            } catch (e: Exception) {
//                // Handle network errors
//                Log.e("ProductFragment", "Error fetching products", e)
//            }
//        }
//    }

//    private fun updateUI(products: List<LatestProductsApi>) {
//        // Populate the RecyclerView with fetched products
//        productAdapter = LatestProductAdapter(products)
//        recyclerView.adapter = productAdapter
//    }
}