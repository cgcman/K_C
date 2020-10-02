package com.grdj.k_c

import android.app.Application
import com.facebook.stetho.BuildConfig
import com.facebook.stetho.Stetho
import com.grdj.k_c.Utils.CrashReportingTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this);
        } else {
            Timber.plant(CrashReportingTree())
        }
    }
}