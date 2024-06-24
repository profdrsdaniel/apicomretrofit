package br.com.ulbra.apicomretrofit.data.repositories

import br.com.ulbra.apicomretrofit.data.Character
import br.com.ulbra.apicomretrofit.data.datasources.CharactersDataSource
import br.com.ulbra.apicomretrofit.data.network.responses.toModel
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val charactersDataSource: CharactersDataSource
) {
    suspend fun fetchCharacters(): List<Character> {
        return charactersDataSource
            .fetchCharacters()
            .charactersResult.map { item -> item.toModel() }
    }
}