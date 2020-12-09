package com.ntz.rickandmortycharacters.data.network.services

import com.ntz.rickandmortycharacters.data.network.model.ApiListResult
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import javax.inject.Inject


class CharacterRepository @Inject constructor() {

    @Inject lateinit var api: CharacterApi

    suspend fun getCharacters() : ApiListResult<ResultModel> {
        return api.getCharacters()
    }
}
