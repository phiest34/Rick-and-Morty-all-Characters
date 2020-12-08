package di.common

import dagger.Component
import di.common.character.CharacterListComponent
import di.common.character.CharacterModule
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