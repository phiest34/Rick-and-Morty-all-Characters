package data.network.services

import data.network.model.ApiListResult
import data.network.model.ResultModel
import javax.inject.Inject


class CharacterRepository @Inject constructor(private val api: CharacterApi) {
    suspend fun getCharacters() : ApiListResult<ResultModel> {
        return api.getCharacters()
    }
}
