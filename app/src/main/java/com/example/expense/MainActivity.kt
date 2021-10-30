package com.example.expense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.expense.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupNavigation()
        onClickNavigate()
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
    // onClickNavigate():
    // This purpose of function is navigated from home fragment to add fragment

    private fun onClickNavigate() = with(binding) {
        fab.setOnClickListener {
            NavHostFragment.findNavController(navHostFragment).navigate(R.id.action_homeFragment_to_addFragment)
        }
    }


}