package di.common.character

import com.example.rickandmortycharacters.ui.list.CharListViewModel
import dagger.Subcomponent
import javax.inject.Singleton


@Subcomponent(modules = [CharacterModule::class])
@CharacterScope
interface CharacterListComponent {
    fun inject(viewModel: CharListViewModel)
}
