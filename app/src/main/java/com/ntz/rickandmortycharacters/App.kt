package com.ntz.rickandmortycharacters

import android.app.Application
import com.ntz.rickandmortycharacters.di.common.ApplicationGraph
import com.ntz.rickandmortycharacters.di.common.DaggerApplicationGraph
import timber.log.Timber

class App : Application() {
    companion object {
        lateinit var appComponent: ApplicationGraph
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationGraph
            .builder()
            .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}