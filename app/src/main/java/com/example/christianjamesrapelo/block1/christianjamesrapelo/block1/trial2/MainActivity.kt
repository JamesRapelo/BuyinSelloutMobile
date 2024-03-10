package com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.fragments.HomeFragment
import com.example.christianjamesrapelo.block1.christianjamesrapelo.block1.trial2.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

        // Add items programmatically
        bottomNavigationView.menu.add(0, R.id.home, 0, "").setIcon(R.drawable.baseline_home_24)
        bottomNavigationView.menu.add(0, R.id.profile, 0, "").setIcon(R.drawable.round_account_circle_24)

        // Set listener for item selection
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                    true
                }
                R.id.profile -> {
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        }

        // Set the default selected fragment
        bottomNavigationView.selectedItemId = R.id.home
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}
