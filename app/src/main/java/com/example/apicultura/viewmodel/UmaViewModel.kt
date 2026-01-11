package com.example.apicultura.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apicultura.model.UmaMusume

class UmaViewModel : ViewModel() {

    private val _umas = MutableLiveData<List<UmaMusume>>()
    val umas: LiveData<List<UmaMusume>> = _umas

    init {
        // De momento vacío
        _umas.value = emptyList()
    }

    fun loadUmas() {
        // TODO: agregar personajes después
    }
}
