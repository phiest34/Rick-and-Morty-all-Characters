package com.example.rickandmortycharacters.ui.list

import androidx.lifecycle.ViewModel
import data.network.model.CharacterData


class CharListViewModel : ViewModel() {
    lateinit var characters: List<CharacterData>
}