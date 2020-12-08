package data

import data.network.model.ApiListResult
import data.network.model.ResultModel
import data.network.services.ApiService


class CharacterRepository(private val remoteSource: ApiService) {
    suspend fun getCharacter(): ApiListResult<ResultModel> {
        return remoteSource.retrofitService.getCharacters()
    }
}