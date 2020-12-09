package com.ntz.rickandmortycharacters.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ntz.rickandmortycharacters.data.network.PagedListProvider
import com.ntz.rickandmortycharacters.data.network.model.ResultModel

class CharListPaginationViewModelFactory(private val pagedListProvider: PagedListProvider<ResultModel?>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharListPaginationViewModel(pagedListProvider) as T
    }
}