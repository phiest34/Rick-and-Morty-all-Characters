package com.ntz.rickandmortycharacters.di.common

import android.content.Context
import com.ntz.rickandmortycharacters.data.network.model.CharacterDataSource
import com.ntz.rickandmortycharacters.data.network.services.CharacterApi
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context
}
