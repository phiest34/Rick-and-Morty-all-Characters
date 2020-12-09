package com.ntz.rickandmortycharacters.data.network.services

import com.ntz.rickandmortycharacters.data.network.model.ApiListResult
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import retrofit2.http.GET


interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(): ApiListResult<ResultModel>
}