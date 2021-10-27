package com.example.expense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    // setupNavigation():
    // This purpose of function is displayed fragments by Navigation Component.

    private fun setupNavigation(){

        // supportFragmentManager:
        // Return the FragmentManager for interacting with fragments associated
        // with this activity.

        // NavHostFragment:
        // NavHostFragment is a container.
        // Inside it, the NavController will display the fragments.

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment?
            ?: return
    }


}