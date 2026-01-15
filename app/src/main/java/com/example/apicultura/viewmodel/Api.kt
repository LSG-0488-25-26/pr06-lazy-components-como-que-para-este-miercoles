package com.example.apicultura.viewmodel


import com.example.apicultura.model.CharacterDetail
import com.example.apicultura.model.CharacterListItem
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("list")
    suspend fun getCharacterList(): List<CharacterListItem>


    @GET("{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int): CharacterDetail

}