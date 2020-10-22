package com.m.phanat.demo.data

import io.realm.DynamicRealm
import io.realm.FieldAttribute
import io.realm.RealmMigration

class RealmMigrations : RealmMigration {
    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        val schema = realm.schema

        if (oldVersion == 1L) {
            schema.create("TestData").apply {
                addField("email", Int::class.javaObjectType, FieldAttribute.PRIMARY_KEY)
                addField("username", String::class.javaObjectType)
            }
        }
        if (oldVersion == 2L) {
            schema.get("TestData")?.apply {
                removePrimaryKey()
                addField("id", Long::class.javaObjectType, FieldAttribute.PRIMARY_KEY)
            }
        }
    }
}