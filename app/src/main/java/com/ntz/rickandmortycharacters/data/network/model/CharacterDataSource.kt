package com.ntz.rickandmortycharacters.data.network.model

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
import com.ntz.rickandmortycharacters.utils.Constants.FIRST_PAGE
import com.ntz.rickandmortycharacters.utils.Constants.SECOND_PAGE
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

class CharacterDataSource(private val dataSource: CharacterRepository) :
    PageKeyedDataSource<Int, ResultModel>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ResultModel?>
    ) {
        Timber.i("callback load initial")

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = dataSource.getCharacterWithPaging(FIRST_PAGE).results
                Timber.i("characters data: ${characters}")
                callback.onResult(characters, null, SECOND_PAGE)
            } catch (t: Throwable)
            {
                t.printStackTrace()
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultModel?>) {
        Timber.d("callback load loadBefore")
        CoroutineScope(Dispatchers.IO).launch {
            val characters = dataSource.getCharacterWithPaging(page = params.key)
            Timber.i("callback load loadBefore")
            callback.onResult(characters.results, params.key.inc())
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultModel?>) {
        CoroutineScope(Dispatchers.IO).launch {
            val characters = dataSource.getCharacterWithPaging(page = params.key)
            callback.onResult(characters.results, params.key.dec())
        }
    }

    companion object {
        fun factory() = object : DataSource.Factory<Int, ResultModel?>() {
            override fun create() = CharacterDataSource(CharacterRepository())
        }
    }
}