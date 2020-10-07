package com.m.phanat.demo.view

import android.content.Context
import android.content.Intent
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.lifecycle.Observer
import com.m.phanat.demo.ViewModel.LoginViewModel
import com.m.phanat.demo.base.BaseActivity
import com.m.phanat.demo.databinding.ActivityLoginBinding
import com.m.phanat.demo.extension.toast


class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val model by lazy { LoginViewModel(application) }

    override fun initView() {
        bindView(ActivityLoginBinding.inflate(layoutInflater))
        hideStatusBar()

        if (model.auth.currentUser != null) {
            val intent = MainActivity.getIntent(this)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        initButton()
        initEditText()
        observe()
    }

    private fun observe() {
        model.singInStatus.observe(this, Observer {
            if (it) {
                toast("signInWithEmail:success")
                startActivity(MainActivity.getIntent(this))
            } else {
                toast("Authentication failed.")
            }
//            binding.layoutContentContainer.showContent()
        })
    }

    private fun initEditText() {
        binding.editTextPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                binding.layoutContentContainer.showLoading()
                model.signIn(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassword.text.toString()
                )
                true
            } else false
        }
    }

    private fun initButton() {
        binding.cirLoginButton.setOnClickListener {
            model.signIn(
                binding.editTextEmail.text.toString(),
                binding.editTextPassword.text.toString()
            )
//            binding.layoutContentContainer.showLoading()
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}