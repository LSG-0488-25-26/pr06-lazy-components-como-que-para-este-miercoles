package com.example.apicultura.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetail(
    val id: Int,
    @SerialName("name_en") val name: String,
    @SerialName("name_en_internal") val nameInternal: String,
    val profile: String?,
    @SerialName("birth_month") val birthMonth: Int?,
    @SerialName("birth_day") val birthDay: Int?,
    @SerialName("color_main") val colorMain: String?
)
