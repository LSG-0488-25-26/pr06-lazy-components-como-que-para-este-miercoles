package com.example.apicultura.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicultura.model.CharacterDetail
import com.example.apicultura.model.CharacterListItem
import com.squareup.moshi.Moshi
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class UmaViewModel : ViewModel() {

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    // 1️⃣ Create Retrofit instance here
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://umapyoi.net/api/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    // 2️⃣ Create API from retrofit
    private val api: UmaApi = retrofit.create(UmaApi::class.java)

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
            selectedCharacter = api.getCharacterDetail(id)
        }
    }
}

object RetrofitInstance {
    private val contentType = "application/json".toMediaType()

    val api: UmaApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://umapyoi.net/api/v1/")
            .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(contentType))
            .build()
            .create(UmaApi::class.java)
    }
}

// --- Retrofit interface ---
interface UmaApi {
    @GET("character/list")
    suspend fun getCharacterList(): List<CharacterListItem>

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: Int): CharacterDetail
}
