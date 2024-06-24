package br.com.ulbra.apicomretrofit.data.network.responses

import com.google.gson.annotations.SerializedName

data class ResultsResponse(
    @SerializedName("results")
    val charactersResult: List<CharactersResponse>
)
