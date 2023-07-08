package com.example.mykonseruts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mykonseruts.fragment.ExploreFragment
import com.example.mykonseruts.fragment.HomeFragment
import com.example.mykonseruts.fragment.LibraryFragment
import com.example.mykonseruts.fragment.SubscriptionFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val subscriptionFragment = SubscriptionFragment()
        val libraryFragment = LibraryFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_explore -> makeCurrentFragment(exploreFragment)
                R.id.menu_subscription -> makeCurrentFragment(subscriptionFragment)
                R.id.menu_library -> makeCurrentFragment(libraryFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }
}