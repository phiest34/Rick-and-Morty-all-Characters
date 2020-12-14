package com.ntz.rickandmortycharacters.di.character

import com.ntz.rickandmortycharacters.data.network.model.CharacterDataSource
import com.ntz.rickandmortycharacters.data.network.model.CharacterDataSourceFactory
import com.ntz.rickandmortycharacters.data.network.services.CharacterApi
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class CharacterModule {

    @Provides
    @CharacterScope
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }

    @Provides
    @CharacterScope
    fun provideFactory(repository: CharacterRepository): CharacterDataSourceFactory {
        return CharacterDataSourceFactory(CharacterDataSource.factory(repository))
    }

    @Provides
    @CharacterScope
    fun provideRepository(api: CharacterApi): CharacterRepository {
        return CharacterRepository(api)
    }
}
