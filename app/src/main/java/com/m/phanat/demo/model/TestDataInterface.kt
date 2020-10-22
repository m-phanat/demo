package com.m.phanat.demo.model

import io.realm.Realm

interface TestDataInterface {
    fun add(realm: Realm, student: TestModel): Boolean
    fun del(realm: Realm, email: String): Boolean
    fun edit(realm: Realm, student: TestModel): Boolean
    fun get(realm: Realm): List<TestModel>
    fun removeLast(realm: Realm)
}