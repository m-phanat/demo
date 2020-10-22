package com.m.phanat.demo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.m.phanat.demo.model.TestDataModel
import com.m.phanat.demo.model.TestModel
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults


class TestDataViewModel : ViewModel() {

    private val realm = Realm.getDefaultInstance()
    private val testModel = TestDataModel()

    private val _data = MutableLiveData<RealmResults<TestModel>>()
    val data: LiveData<RealmResults<TestModel>>
        get() = _data

    var listener: RealmChangeListener<RealmResults<TestModel>> =
        RealmChangeListener<RealmResults<TestModel>> { results ->
            if (results.isLoaded) {
                println("realm load data $results")
                _data.value = results
            }
        }

    fun add(data: TestModel) {
        testModel.add(realm, data)
    }

    fun del(email: String) {
        testModel.del(realm, email)
    }

    fun get() {
        val results = testModel.get(realm)
        _data.value = results
        results.addChangeListener(listener)
    }

    override fun onCleared() {
        super.onCleared()
        realm.close()
    }

}