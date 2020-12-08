package com.ntz.rickandmortycharacters.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
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



