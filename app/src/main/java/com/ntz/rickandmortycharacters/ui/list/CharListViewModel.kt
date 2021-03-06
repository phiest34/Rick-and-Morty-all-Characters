package com.ntz.rickandmortycharacters.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ntz.rickandmortycharacters.App
import com.ntz.rickandmortycharacters.data.network.model.ResultModel
import com.ntz.rickandmortycharacters.data.network.services.CharacterRepository
import com.ntz.rickandmortycharacters.di.character.CharacterModule
import kotlinx.coroutines.*
import javax.inject.Inject

class CharListViewModel : ViewModel() {
    @Inject
    lateinit var dataSource: CharacterRepository

    private var characters: MutableLiveData<List<ResultModel>> = MutableLiveData()

    init {
        App.appComponent.inject(CharacterModule()).inject(this)
    }

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



