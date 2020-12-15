package com.ntz.rickandmortycharacters.data.network.model

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
import com.ntz.rickandmortycharacters.utils.Constants.FIRST_PAGE
import com.ntz.rickandmortycharacters.utils.Constants.SECOND_PAGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class CharacterDataSource constructor(private val repository: CharacterRepository) :
    PageKeyedDataSource<Int, ResultModel>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ResultModel>
    ) {
        Timber.i("callback load initial")

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = repository.getCharacterWithPaging(FIRST_PAGE)
                callback.onResult(characters.results, null, SECOND_PAGE)
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultModel>) {
        Timber.d("callback load Before")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = repository.getCharacterWithPaging(page = params.key)
                callback.onResult(characters.results, params.key.inc())
            } catch (t: Throwable) {
                t.printStackTrace()
            }

        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = repository.getCharacterWithPaging(page = params.key)
                callback.onResult(characters.results, params.key.dec())
            } catch (t: Throwable) {
                t.printStackTrace()
            }

        }
    }

    companion object {
        fun factory(repository: CharacterRepository) =
            object : DataSource.Factory<Int, ResultModel?>() {

                override fun create() = CharacterDataSource(repository)
            }
    }
}