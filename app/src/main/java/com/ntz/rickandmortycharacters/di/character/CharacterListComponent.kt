package com.ntz.rickandmortycharacters.di.character

import android.app.Activity
import com.ntz.rickandmortycharacters.ui.list.CharListFragment
import com.ntz.rickandmortycharacters.ui.list.CharListPaginationViewModel
import dagger.Subcomponent


@Subcomponent(modules = [CharacterModule::class])
@CharacterScope
interface CharacterListComponent {
    fun inject(fragment: CharListFragment)

    fun inject(viewModel: CharListPaginationViewModel)
}
