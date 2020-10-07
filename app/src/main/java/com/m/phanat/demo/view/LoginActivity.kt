package com.m.phanat.demo.view

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import com.google.firebase.auth.FirebaseAuth
import com.m.phanat.demo.base.BaseActivity
import com.m.phanat.demo.databinding.ActivityLoginBinding
import com.m.phanat.demo.extension.toast


class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private lateinit var auth: FirebaseAuth

    override fun initView() {
        bindView(ActivityLoginBinding.inflate(layoutInflater))
        hideStatusBar()
        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            val intent = MainActivity.getIntent(this)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        binding.editTextPassword.setOnEditorActionListener(OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                toast("login")
                signIn(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassword.text.toString()
                )
                true
            } else false
        })

        binding.cirLoginButton.setOnClickListener {
            signIn(binding.editTextEmail.text.toString(), binding.editTextPassword.text.toString())
        }
    }

    private fun signIn(email: String, password: String) {


        Log.d(TAG, "signIn:$email $password")

        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    toast("signInWithEmail:success")
                    startActivity(MainActivity.getIntent(this))
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    toast("Authentication failed.")

                    // [END_EXCLUDE]
                }

                // [START_EXCLUDE]
                if (!task.isSuccessful) {
                    toast("Authentication failed.")
                }
            }
    }


    companion object {
        fun getIntent(context: Context) = Intent(context, LoginActivity::class.java)
        private const val TAG = "EmailPassword"
        private const val RC_MULTI_FACTOR = 9005
    }
}