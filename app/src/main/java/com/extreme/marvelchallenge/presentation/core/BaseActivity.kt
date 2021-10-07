package com.extreme.marvelchallenge.presentation.core

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author Mahmoud Shehatah
 * Created 06/10/2021 at 10:48 PM
 */
abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
    viewModelClass: Class<VM>
) : AppCompatActivity() {

    protected lateinit var binding: DB

    val viewModel: VM by lazy {
        ViewModelProvider(this)[viewModelClass]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId) as DB
        binding.run {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@BaseActivity
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        val newOverride = Configuration(newBase?.resources?.configuration)
        newOverride.fontScale = 1.0f
        applyOverrideConfiguration(newOverride)
    }
}
