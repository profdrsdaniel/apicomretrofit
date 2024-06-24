package br.com.ulbra.apicomretrofit.commons

sealed class Resultado<out T> {
    data object Loading : Resultado<Nothing>()
    data class Success<out T>(val data: T) : Resultado<T>()
    data class Error(val exception: Exception) : Resultado<Nothing>()
}