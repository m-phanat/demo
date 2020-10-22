package com.m.phanat.demo.view

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.m.phanat.demo.adapter.ListDataAdapter
import com.m.phanat.demo.base.BaseActivity
import com.m.phanat.demo.databinding.ActivityListDatabaseBinding
import com.m.phanat.demo.model.TestModel
import com.m.phanat.demo.viewModel.TestDataViewModel


class ListDatabaseActivity : BaseActivity<ActivityListDatabaseBinding>() {

    private lateinit var adapter: ListDataAdapter
    private val viewModel by lazy { TestDataViewModel() }


    override fun initView() {
        bindView(ActivityListDatabaseBinding.inflate(layoutInflater))

        viewModel.get()

        updateUi()
        adapter = ListDataAdapter {
            viewModel.del(it)
        }
        binding.rvListDB.layoutManager = LinearLayoutManager(this)
        binding.rvListDB.adapter = adapter

        binding.add.setOnClickListener {
            val data = TestModel()
            data.email = binding.inputText.text.toString()
            data.username = binding.inputText.text.toString()
            viewModel.add(data)
            binding.inputText.setText("")
        }
    }

    private fun updateUi() {
        viewModel.data.observe(this, {
            adapter.load(it)
        })
    }

}


