package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api.RetrofitClient
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.activity.FeaturedProductAdapter
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.activity.LatestProductAdapter
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.databinding.FragmentHomeBinding
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.FeaturedProductApi
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.FeaturedProducts
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.LatestProducts
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.LatestProductsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var latestProductAdapter: LatestProductAdapter
    private lateinit var featuredProductAdapter: FeaturedProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        latestProductAdapter = LatestProductAdapter(emptyList())
        binding.recyclerViewLatestProducts.adapter = latestProductAdapter
        binding.recyclerViewLatestProducts.layoutManager = LinearLayoutManager(requireContext())
        featuredProductAdapter = FeaturedProductAdapter(emptyList())
        binding.recyclerViewFeaturedProducts.adapter = latestProductAdapter
        binding.recyclerViewFeaturedProducts.layoutManager = LinearLayoutManager(requireContext())
        latestProducts()

        return binding.root
    }

    private fun latestProducts() {
        RetrofitClient.instance.getProducts().enqueue(object : Callback<List<LatestProductsApi>> {
            override fun onResponse(call: Call<List<LatestProductsApi>>, response: Response<List<LatestProductsApi>>) {
                if (response.isSuccessful) {
                    val latestProductsApi = response.body() ?: emptyList()
                    val newProducts = latestProductsApi.map { latestProductsApi ->
                        LatestProducts(
                            title = latestProductsApi.title,
                            description = latestProductsApi.description,
                            price = latestProductsApi.price
                        )
                    }
                    latestProductAdapter.updateData(newProducts)
                } else {
                    Toast.makeText(requireContext(), "Failed to get latest products", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<LatestProductsApi>>, t: Throwable) {
                Log.e("AccountFragment", "Failed to get latest products", t)
                Toast.makeText(requireContext(), "Failed to get latest products", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun featuredProducts() {
        RetrofitClient.instance.getFeaturedProducts().enqueue(object : Callback<List<FeaturedProductApi>> {
            override fun onResponse(call: Call<List<FeaturedProductApi>>, response: Response<List<FeaturedProductApi>>) {
                if (response.isSuccessful) {
                    val featuredProductsApi = response.body() ?: emptyList()
                    val newProducts = featuredProductsApi.map { featuredProductsApi ->
                        FeaturedProducts(
                            title = featuredProductsApi.title,
                            description = featuredProductsApi.description,
                            price = featuredProductsApi.price
                        )
                    }
                    featuredProductAdapter.updateData(newProducts)
                } else {
                    Toast.makeText(requireContext(), "Failed to get featured products", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<FeaturedProductApi>>, t: Throwable) {
                Log.e("AccountFragment", "Failed to get featured products", t)

            }
        })
    }

}