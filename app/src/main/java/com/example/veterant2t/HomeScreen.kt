package com.example.veterant2t

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.veterant2t.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {

    public lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home->{
                    updateFragment(HomeFragment())

                }
                R.id.navigation_dashboard->{
                    updateFragment(DashboardFragment())

                }
                R.id.navigation_notifications->{
                    updateFragment(NotifFragment())

                }
                else->{

                }
            }
            true
        }
    }

    fun updateFragment(fragment: Fragment){
        val fragManager=supportFragmentManager
        val fragTransaction=fragManager.beginTransaction()
        fragTransaction.replace(R.id.fragmentContainerView,fragment)
        fragTransaction.commit()
    }
}