package br.com.ulbra.apicomretrofit.data.di

import br.com.ulbra.apicomretrofit.data.datasources.CharactersDataSource
import br.com.ulbra.apicomretrofit.data.network.CharactersApi
import br.com.ulbra.apicomretrofit.data.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesDataSourceModule(
        api: CharactersApi
    ): CharactersDataSource {
        return CharactersDataSource(api)
    }
}