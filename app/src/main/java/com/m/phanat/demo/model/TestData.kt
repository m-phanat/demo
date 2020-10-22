package com.m.phanat.demo.model

import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@RealmClass
open class TestModel : RealmObject(), Parcelable {
    @PrimaryKey
    var id: Long? = null
    var email: String? = null
    var username: String? = null
}