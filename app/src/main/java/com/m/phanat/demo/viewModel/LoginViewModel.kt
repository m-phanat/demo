package com.m.phanat.demo.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.m.phanat.demo.base.BaseViewModel

class LoginViewModel(application: Application) : BaseViewModel(application) {
    val auth by lazy { FirebaseAuth.getInstance() }


    val singInStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                singInStatus.value = task.isSuccessful
            }
    }
}