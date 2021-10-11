package com.extreme.marvelchallenge.presentation.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.databinding.ActivityMainBinding
import com.extreme.marvelchallenge.presentation.core.BaseActivity
import com.extreme.marvelchallenge.presentation.util.getLanguage
import com.extreme.marvelchallenge.presentation.util.hide
import com.extreme.marvelchallenge.presentation.util.show
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

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
        setLang()
    }

    private fun setLang() {
        val lang = if (getLanguage() == "ar" || getLanguage() == "en") getLanguage() else "en"
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = applicationContext.resources.configuration
        config.setLocale(locale)
        applicationContext.createConfigurationContext(config)
        applicationContext.resources.updateConfiguration(
            config,
            applicationContext.resources.displayMetrics
        )
    }

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
    }

    private val navController: NavController by lazy {
        navHostFragment.navController
    }

    private val onDestinationChangedListener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    binding.toolbarCrd.hide()
                }
                R.id.homeFragment -> {
                    binding.toolbarCrd.show()
                }
                R.id.searchFragment -> {
                    binding.toolbarCrd.hide()
                }
                R.id.detailsFragment -> {
                    binding.toolbarCrd.hide()
                }
            }
        }

    private fun setupNavigation() {
        val appBarConfig = AppBarConfiguration(
            setOf(R.id.homeFragment)
        )
        setupWithNavController(binding.toolbar, navController, appBarConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuItemSearch -> {
                findNavController(R.id.container_fragment).navigate(R.id.searchFragment)
                true
            }
            else -> false
        }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(onDestinationChangedListener)
    }

    override fun onPause() {
        navController.removeOnDestinationChangedListener(onDestinationChangedListener)
        super.onPause()
    }
}
