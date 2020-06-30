package io.minseok.imagesearchapp

import android.app.Application
import io.minseok.imagesearchapp.app.appModules
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        /* Koin */
        startKoin(this, appModules)
    }
}