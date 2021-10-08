package com.extreme.marvelchallenge.presentation.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.databinding.ActivityMainBinding
import com.extreme.marvelchallenge.presentation.core.BaseActivity
import com.extreme.marvelchallenge.presentation.util.hide
import com.extreme.marvelchallenge.presentation.util.show
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Mahmoud Shehatah
 * Created 06/10/2021 at 11:31 PM
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    MainActivityViewModel::class.java
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setupNavigation()
    }

    private fun setupNavigation() {
        val appBarConfig = AppBarConfiguration(
            setOf(R.id.homeFragment)
        )

        val navController = findNavController(R.id.container_fragment)
        binding.toolbar.navigationIcon?.setTint(Color.parseColor("#ffffff"))
        setupWithNavController(binding.toolbar, navController, appBarConfig)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    binding.toolbar.hide()
                }
                R.id.homeFragment -> {
                    binding.toolbar.show()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}
