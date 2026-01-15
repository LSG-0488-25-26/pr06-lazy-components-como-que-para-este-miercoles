package com.example.apicultura.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    var characterList by mutableStateOf<List<CharacterListItem>>(emptyList())
        private set

    var selectedCharacter by mutableStateOf<CharacterDetail?>(null)
        private set

    init {
        loadCharacterList()
    }

    fun loadCharacterList() {
        viewModelScope.launch {
            characterList = api.getCharacterList()
        }
    }

    fun loadCharacterDetail(id: Int) {
        viewModelScope.launch {
            selectedCharacter = api.getCharacterById(id)
        }
    }
}