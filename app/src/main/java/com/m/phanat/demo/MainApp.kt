package com.m.phanat.demo

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.m.phanat.demo.data.RealmMigrations
import com.onesignal.OneSignal
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration

open class MainApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val realmConfig =
            RealmConfiguration.Builder().schemaVersion(2).migration(RealmMigrations()).build()
        Realm.setDefaultConfiguration(realmConfig)


        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()
    }
}