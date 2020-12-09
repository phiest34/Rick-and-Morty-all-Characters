package com.ntz.rickandmortycharacters

import android.app.Application
import androidx.paging.DataSource
import com.ntz.rickandmortycharacters.data.network.model.CharacterDataSource
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import com.ntz.rickandmortycharacters.di.common.ApplicationGraph
import com.ntz.rickandmortycharacters.di.common.DaggerApplicationGraph
import timber.log.Timber

class App : Application() {
    companion object {
        lateinit var appComponent: ApplicationGraph
    }

     var factory: DataSource.Factory<Int, ResultModel?> = CharacterDataSource.factory()

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