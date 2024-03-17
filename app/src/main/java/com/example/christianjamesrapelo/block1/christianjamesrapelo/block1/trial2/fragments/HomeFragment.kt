package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.databinding.FragmentHomeBinding
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.fragments.GetFragment


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }
}