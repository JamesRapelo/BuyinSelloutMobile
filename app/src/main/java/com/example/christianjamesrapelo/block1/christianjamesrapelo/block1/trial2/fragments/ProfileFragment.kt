package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.Api.RetrofitClient
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.R
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.databinding.FragmentProfileBinding
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        sharedPreferences = requireActivity().getSharedPreferences("myPreference", Context.MODE_PRIVATE)
        val authToken = sharedPreferences.getString("authToken", "")
        authToken.toString().let { getUserInfo(it) }

        return binding.root
    }
    private fun getUserInfo(authToken: String) {
        RetrofitClient.instance.getUser("Bearer $authToken").enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val userData = response.body()
                    if (userData != null) {
                        updateInfo(userData)
                    }

                    val responseBody = response.body().toString()
                    Log.d("Response", responseBody)
                } else {
                    // Handle unsuccessful response
                    Toast.makeText(requireContext(), "Failed to get user info", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("AccountFragment", "Failed to get user info", t)
                Toast.makeText(requireContext(), "Failed to get user info", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun updateInfo(userData: User) {
        if (userData != null) {
            binding.etname.text = Editable.Factory.getInstance().newEditable(userData.name)
            binding.etEmail.text = Editable.Factory.getInstance().newEditable(userData.email)
            binding.etPhone.text = Editable.Factory.getInstance().newEditable(userData.phone)
        }
    }

}