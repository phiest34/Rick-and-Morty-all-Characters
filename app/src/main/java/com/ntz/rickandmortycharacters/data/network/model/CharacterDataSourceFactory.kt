package com.ntz.rickandmortycharacters.data.network.model

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ntz.rickandmortycharacters.data.network.PagedListProvider
import com.ntz.rickandmortycharacters.utils.Constants.PAGE_SIZE
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CharacterDataSourceFactory(
    private val factory: DataSource.Factory<Int, ResultModel?>
) :
    PagedListProvider<ResultModel?> {
    override fun provide(): LiveData<PagedList<ResultModel?>> {
        return LivePagedListBuilder(
            factory, PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(PAGE_SIZE)
                .setInitialLoadSizeHint(PAGE_SIZE)
                .build()
        ).setFetchExecutor(createFetchExecutor())
            .build()
    }

    private fun createFetchExecutor(): ExecutorService {
        val nThreads = Runtime.getRuntime().availableProcessors() + 1
        return Executors.newFixedThreadPool(nThreads)
    }
}