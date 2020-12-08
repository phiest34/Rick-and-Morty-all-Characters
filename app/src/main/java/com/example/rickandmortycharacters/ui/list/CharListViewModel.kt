package com.example.rickandmortycharacters.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.network.model.ResultModel
import data.network.services.CharacterRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class CharListViewModel @Inject constructor(private val dataSource: CharacterRepository) : ViewModel() {
    private var characters: MutableLiveData<List<ResultModel>> = MutableLiveData()

    fun getCharactersListObserver(): MutableLiveData<List<ResultModel>> {
        return characters
    }

    fun makeApiCall() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = dataSource.getCharacters().results
                characters.postValue(list)
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}



