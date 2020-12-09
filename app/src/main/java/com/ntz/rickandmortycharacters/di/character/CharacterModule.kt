package com.ntz.rickandmortycharacters.di.character

import com.ntz.rickandmortycharacters.data.network.services.CharacterApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject


@Module
class CharacterModule {
    @Provides
    @CharacterScope
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }
}
