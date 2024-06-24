package br.com.ulbra.apicomretrofit.data.datasources

import br.com.ulbra.apicomretrofit.data.network.CharactersApi
import br.com.ulbra.apicomretrofit.data.network.responses.ResultsResponse
import javax.inject.Inject

class CharactersDataSource @Inject constructor(
    private val api: CharactersApi
) {
    suspend fun fetchCharacters(): ResultsResponse {
        return api.fetchCharacters()
    }
}