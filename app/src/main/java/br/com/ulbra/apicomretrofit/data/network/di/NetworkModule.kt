package br.com.ulbra.apicomretrofit.data.network.di

import br.com.ulbra.apicomretrofit.data.network.CharactersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesCharactersService(retrofit: Retrofit): CharactersApi {
        return retrofit.create(CharactersApi::class.java)
    }
}