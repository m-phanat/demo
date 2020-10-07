package com.m.phanat.demo.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.m.phanat.demo.base.BaseViewModel
import com.m.phanat.demo.extension.toast
import com.m.phanat.demo.view.LoginActivity
import com.m.phanat.demo.view.MainActivity

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