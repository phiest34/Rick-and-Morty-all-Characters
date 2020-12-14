package com.ntz.rickandmortycharacters.ui.list

import androidx.lifecycle.ViewModel
import com.ntz.rickandmortycharacters.data.network.PagedListProvider
import com.ntz.rickandmortycharacters.data.network.model.ResultModel

class CharListPaginationViewModel(
    pagedListProvider: PagedListProvider<ResultModel?>
) : ViewModel() {

    val pagedListData = pagedListProvider.provide()
}