package com.example.rickandmortycharacters.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.CharacterRepository
import data.network.model.ResultModel
import kotlinx.coroutines.*

class CharListViewModel(private val dataSource: CharacterRepository) : ViewModel() {
    private var characters: MutableLiveData<List<ResultModel>> = MutableLiveData()

    fun getCharactersListObserver(): MutableLiveData<List<ResultModel>> {
        return characters
    }

    fun makeApiCall() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = dataSource.getCharacter().results
                characters.postValue(list)
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}



