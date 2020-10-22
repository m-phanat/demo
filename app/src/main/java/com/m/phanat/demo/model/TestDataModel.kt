package com.m.phanat.demo.model

import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import io.realm.kotlin.where

class TestDataModel : TestDataInterface {
    override fun add(realm: Realm, t: TestModel): Boolean {
        val currentIdNum: Number = realm.where(TestModel::class.java).max("id") ?: 0
        t.id = currentIdNum.toLong() + 1
        return try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(t)
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            println(e)
            false
        }
    }

    override fun del(realm: Realm, email: String): Boolean {
        return try {
            realm.beginTransaction()
            realm.where(TestModel::class.java)
                .equalTo("email", email)
                .findFirst()
                ?.deleteFromRealm()
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            println(e)
            false
        }
    }

    override fun edit(realm: Realm, student: TestModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(realm: Realm): RealmResults<TestModel> {
        return realm.where<TestModel>().findAllAsync().sort("id", Sort.ASCENDING)
    }

    override fun removeLast(realm: Realm) {
        TODO("Not yet implemented")
    }
}