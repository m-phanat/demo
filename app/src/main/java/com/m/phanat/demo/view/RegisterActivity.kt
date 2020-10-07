package com.m.phanat.demo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.m.phanat.demo.base.BaseActivity
import com.m.phanat.demo.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {
    override fun initView() {
        bindView(ActivityRegisterBinding.inflate(layoutInflater))
    }
}