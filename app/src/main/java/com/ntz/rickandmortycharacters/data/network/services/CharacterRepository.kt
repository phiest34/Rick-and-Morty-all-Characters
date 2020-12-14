package com.ntz.rickandmortycharacters.data.network.services

import com.ntz.rickandmortycharacters.data.network.model.ApiListResult
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import javax.inject.Inject


class CharacterRepository @Inject constructor(private val api: CharacterApi) {

    suspend fun getCharacterWithPaging(page: Int) : ApiListResult<ResultModel> {
        return api.getCharactersWithPagingAsync(page)
    }
}
