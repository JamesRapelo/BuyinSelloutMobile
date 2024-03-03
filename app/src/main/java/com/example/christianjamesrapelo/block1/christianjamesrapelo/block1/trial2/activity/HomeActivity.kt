package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.R
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardView2.setOnClickListener {
            startActivity(Intent(this, GetFragment::class.java))
        }

        binding.cardView3.setOnClickListener {
            startActivity(Intent(this, GetFragment::class.java))
        }

        binding.cardView4.setOnClickListener {
            startActivity(Intent(this, GetFragment::class.java))
        }

        binding.cardView5.setOnClickListener {
            startActivity(Intent(this, GetFragment::class.java))
        }

        binding.cardView6.setOnClickListener {
            startActivity(Intent(this, GetFragment::class.java))
        }

        binding.cardView7.setOnClickListener {
            startActivity(Intent(this, GetFragment::class.java))
        }
    }
}
