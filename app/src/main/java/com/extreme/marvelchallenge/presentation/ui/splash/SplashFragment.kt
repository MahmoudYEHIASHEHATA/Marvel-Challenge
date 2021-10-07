package com.extreme.marvelchallenge.presentation.ui.splash

import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.databinding.FragmentSplashBinding
import com.extreme.marvelchallenge.presentation.core.BaseFragment
import com.extreme.marvelchallenge.presentation.core.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Mahmoud Shehatah
 * Created 07/10/2021 at 12:01 AM
 */
@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentViewModel, FragmentSplashBinding>(
    R.layout.fragment_splash,
    SplashFragmentViewModel::class.java,
) {

    override fun init() {
        super.init()
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        lifecycleScope.launch(context = Dispatchers.Main) {
            delay(Constants.Splash.DELAY_TIME)
            startNavigate()
        }
    }

    private fun startNavigate() {
        findNavController().graph.startDestination =
            R.id.homeFragment // Little bit tricky solution :)
        navigate(R.id.action_splashFragment_to_homeFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}
