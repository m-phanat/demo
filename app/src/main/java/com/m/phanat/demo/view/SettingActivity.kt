package com.m.phanat.demo.view

import android.content.Context
import android.content.Intent
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.google.android.material.switchmaterial.SwitchMaterial
import com.m.phanat.demo.R
import com.m.phanat.demo.base.BaseActivity
import com.m.phanat.demo.databinding.ActivitySettingBinding
import com.m.phanat.demo.preference.DarkModePrefManager


class SettingActivity : BaseActivity<ActivitySettingBinding>() {
    private lateinit var darkModeSwitch: SwitchMaterial

    companion object {
        fun getIntent(context: Context) = Intent(context, SettingActivity::class.java)
    }

    override fun initView() {
        bindView(ActivitySettingBinding.inflate(layoutInflater))
        if (DarkModePrefManager(this).isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        //function for enabling dark mode
        //function for enabling dark mode
        setDarkModeSwitch()


        window.statusBarColor = ContextCompat.getColor(this, R.color.contentBodyColor);// set status background white
    }

    private fun setDarkModeSwitch() {
        darkModeSwitch = binding.darkModeSwitch
        darkModeSwitch.isChecked = DarkModePrefManager(this).isNightMode
        darkModeSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, _ ->
            val darkModePrefManager = DarkModePrefManager(this)
            darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            recreate()
        })
    }
}