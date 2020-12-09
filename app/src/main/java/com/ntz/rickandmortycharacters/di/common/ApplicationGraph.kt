package com.ntz.rickandmortycharacters.di.common

import com.ntz.rickandmortycharacters.di.character.CharacterListComponent
import dagger.Component
import com.ntz.rickandmortycharacters.di.character.CharacterModule
import javax.inject.Singleton

/*
* Keep an instance of that component in your
* custom application class and call
* it every time you need the application graph
*
* */

@Component(modules = [AppModule::class, NetworkModule::class])
@Singleton
interface ApplicationGraph {
   fun inject(module: CharacterModule): CharacterListComponent
}
