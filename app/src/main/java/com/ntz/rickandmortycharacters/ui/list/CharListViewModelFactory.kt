package com.ntz.rickandmortycharacters.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
import javax.inject.Inject

class CharListViewModelFactory
@Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var dataSource: CharacterRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.i("CharListViewModelFactor","Called ViewModelFactor!")
        if (modelClass.isAssignableFrom(CharListViewModel::class.java)) {
            return CharListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}