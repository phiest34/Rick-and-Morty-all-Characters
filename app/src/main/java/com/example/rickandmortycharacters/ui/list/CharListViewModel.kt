package com.example.rickandmortycharacters.ui.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.CharacterRepository
import data.network.model.CharacterModel
import data.network.model.ResultModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharListViewModel(private val dataSource: CharacterRepository) : ViewModel() {
    private var characters: MutableLiveData<List<ResultModel>> = MutableLiveData()

    fun getCharactersListObserver(): MutableLiveData<List<ResultModel>> {
        return characters
    }

    fun makeApiCall() {
        CoroutineScope(Dispatchers.IO).launch {

            try {

                val list = dataSource.getCharacter().results
                Log.i("make api call", "got response")
                characters.postValue(list)
            } catch (t: Throwable) {
                t.printStackTrace()
                Log.i("make api call", "no response")
            }
        }
//        val call: Call<List<CharacterModel>> = dataSource.getCharacter()
//        call.enqueue(object : Callback<List<CharacterModel>> {
//            override fun onResponse(
//                call: Call<List<CharacterModel>>?,
//                response: Response<List<CharacterModel>>
//            ) {

//                characters.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<List<CharacterModel>>?, t: Throwable) {
//
//            }
//        })

    }
}



