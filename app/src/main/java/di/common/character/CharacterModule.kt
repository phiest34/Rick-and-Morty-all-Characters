package di.common.character

import dagger.Module
import dagger.Provides
import data.network.services.CharacterApi
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject


@Module
class CharacterModule @Inject constructor(private val retrofit: Retrofit) {
    @Provides
    @CharacterScope
    fun provideCharacterApi(): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }
}
