package com.ntz.rickandmortycharacters.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
import javax.inject.Inject

class CharListViewModelFactory
@Inject constructor(
    private val dataSource: CharacterRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharListViewModel::class.java)) {
            return CharListViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}