package com.ntz.rickandmortycharacters.data.network

import androidx.lifecycle.LiveData
import androidx.paging.PagedList


interface PagedListProvider<T> {
    fun provide() : LiveData<PagedList<T>>
}