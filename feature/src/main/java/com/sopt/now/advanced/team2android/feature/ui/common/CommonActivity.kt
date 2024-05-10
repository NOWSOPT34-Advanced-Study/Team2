package com.sopt.now.advanced.team2android.feature.ui.common

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.advanced.team2android.feature.R
import com.sopt.now.advanced.team2android.feature.databinding.ActivityCommonBinding
import com.sopt.now.advanced.team2android.feature.model.BottomNavItems
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingActivity

@AndroidEntryPoint
class CommonActivity :
    BindingActivity<ActivityCommonBinding>({ ActivityCommonBinding.inflate(it) }) {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNavHost()
    }

    private fun setupNavHost() {
        setupNavHostFragment()
        setupDestinationListener()
        setupBottomNavigation()
    }

    private fun setupNavHostFragment() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_common_nav_host) as NavHostFragment?
                ?: return
        navController = navHostFragment.navController
    }

    private fun setupDestinationListener() {
        navController.addOnDestinationChangedListener { _: NavController?, destination: NavDestination, _: Bundle? ->
            changeVisibilityOfBottomNav(destination)
        }
    }

    private fun changeVisibilityOfBottomNav(destination: NavDestination) {
        if (destination.id in BottomNavItems.bottomNavItems) {
            binding.bnvMain.visibility = View.VISIBLE
        } else {
            binding.bnvMain.visibility = View.GONE
        }
    }

    private fun setupBottomNavigation() {
        binding.bnvMain.setupWithNavController(navController)
        binding.bnvMain.setOnItemSelectedListener { item ->
            handleBottomNavItemClick(item)
            return@setOnItemSelectedListener true
        }
    }

    private fun handleBottomNavItemClick(item: MenuItem) {
        NavigationUI.onNavDestinationSelected(item, navController)
        Snackbar.make(binding.root, item.title.toString(), Snackbar.LENGTH_SHORT).show()
    }
}
