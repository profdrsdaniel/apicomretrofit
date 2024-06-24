package br.com.ulbra.apicomretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import br.com.ulbra.apicomretrofit.commons.Resultado
import br.com.ulbra.apicomretrofit.data.repositories.CharactersRepository
import br.com.ulbra.apicomretrofit.databinding.ActivityMainBinding
import br.com.ulbra.apicomretrofit.ui.CharactersViewModel
import br.com.ulbra.apicomretrofit.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterAdapter
    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureRecycler()
        observer()
    }

    private fun configureRecycler() {
        adapter = CharacterAdapter()
        binding.rcCharacters.adapter = adapter
    }

    private fun observer() {
        charactersViewModel.fetchCharacters().observe(this) { result ->
            when(result) {
                is Resultado.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resultado.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setUpCharacters(result.data)
                }

                is Resultado.Error -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}