package data.network.services

import data.network.model.ApiListResult
import data.network.model.ResultModel
import retrofit2.http.GET


interface CharacterService {
    @GET("character")
    suspend fun getCharacters(): ApiListResult<ResultModel>
}