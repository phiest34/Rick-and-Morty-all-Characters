package com.ntz.rickandmortycharacters.di.character

import com.ntz.rickandmortycharacters.ui.list.CharListViewModel
import dagger.Subcomponent


@Subcomponent(modules = [CharacterModule::class])
@CharacterScope
interface CharacterListComponent {
    fun inject(viewModel: CharListViewModel)
}
