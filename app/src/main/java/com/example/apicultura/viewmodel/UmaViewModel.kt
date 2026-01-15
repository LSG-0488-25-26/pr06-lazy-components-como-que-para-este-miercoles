package com.example.apicultura.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicultura.model.CharacterDetail
import com.example.apicultura.model.CharacterListItem
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UmaViewModel : ViewModel() {
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://umapyoi.net/api/v1/character/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val api: Api = retrofit.create(Api::class.java)
    private val _characterList = MutableLiveData<List<CharacterListItem>>()
    val characterList: LiveData<List<CharacterListItem>> = _characterList

    private val _selectedCharacter = MutableLiveData<CharacterDetail?>()
    val selectedCharacter: LiveData<CharacterDetail?> = _selectedCharacter

    init {
        loadCharacterList()
    }

    fun loadCharacterList() {
        viewModelScope.launch {
            try {
                val list = api.getCharacterList() // make sure API returns List<CharacterListItem>
                _characterList.postValue(list)
            } catch (e: Exception) {
                _characterList.postValue(emptyList()) // or handle error
            }
        }
    }

    fun loadCharacterDetail(id: Int) {
        viewModelScope.launch {
            try {
                val detail = api.getCharacterById(id) // make sure API returns CharacterDetail
                _selectedCharacter.postValue(detail)
            } catch (e: Exception) {
                _selectedCharacter.postValue(null)
            }
        }
    }
}