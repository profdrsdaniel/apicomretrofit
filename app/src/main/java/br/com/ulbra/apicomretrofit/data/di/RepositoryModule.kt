package br.com.ulbra.apicomretrofit.data.di

import br.com.ulbra.apicomretrofit.data.datasources.CharactersDataSource
import br.com.ulbra.apicomretrofit.data.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesCharactersRepository(
        charactersDataSource: CharactersDataSource
    ): CharactersRepository {
        return CharactersRepository(charactersDataSource)
    }
}