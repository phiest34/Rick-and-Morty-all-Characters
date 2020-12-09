package com.ntz.rickandmortycharacters.data.network.services

import com.ntz.rickandmortycharacters.data.network.model.ApiListResult
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(): ApiListResult<ResultModel>

    @GET("character")
    suspend fun getCharactersWithPagingAsync(@Query("page") page: Int): Deferred<ApiListResult<ResultModel>>
}