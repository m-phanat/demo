package com.m.phanat.demo.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.m.phanat.demo.base.BaseActivity
import com.m.phanat.demo.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val auth by lazy { FirebaseAuth.getInstance() }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun initView() {
        bindView(ActivityMainBinding.inflate(layoutInflater))
        binding.logout.setOnClickListener {
            singOut()
        }
    }

    private fun singOut() {
        auth.signOut()
        val intent = LoginActivity.getIntent(this)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}