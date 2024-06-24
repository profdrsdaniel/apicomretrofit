package br.com.ulbra.apicomretrofit.data.network.responses

import br.com.ulbra.apicomretrofit.data.Character
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String
)

fun CharactersResponse.toModel() = Character(
    name = this.name,
    image = this.image
)
