package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.R
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.cardView2.setOnClickListener{
            val kidsFragment = GetFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(androidx.fragment.R.id.fragment_container_view_tag, kidsFragment)
                .addToBackStack(null)
                .commit()

        }
        binding.cardView3.setOnClickListener{
            val menFragment = GetFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(androidx.fragment.R.id.fragment_container_view_tag, menFragment)
                .addToBackStack(null)
                .commit()

        }
        binding.cardView4.setOnClickListener{
            val womenFragment = GetFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(androidx.fragment.R.id.fragment_container_view_tag, womenFragment)
                .addToBackStack(null)
                .commit()

        }
        binding.cardView5.setOnClickListener {
            val applianceFragment = GetFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(androidx.fragment.R.id.fragment_container_view_tag, applianceFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.cardView6.setOnClickListener {
            val electronicsFragment = GetFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(androidx.fragment.R.id.fragment_container_view_tag, electronicsFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.cardView7.setOnClickListener {
            val accesoriesFragment = GetFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(androidx.fragment.R.id.fragment_container_view_tag, accesoriesFragment)
                .addToBackStack(null)
                .commit()
        }



        return binding.root
    }
}