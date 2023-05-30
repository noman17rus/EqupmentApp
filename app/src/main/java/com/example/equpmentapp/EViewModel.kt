package com.example.equpmentapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.util.Date

open class EViewModel : ViewModel() {
    var name = MutableLiveData("")
    val dateOfStart = MutableLiveData("")
    val dateOfEnd = MutableLiveData("")

    fun editName(name: String) {
        this.name.value = name
    }
}