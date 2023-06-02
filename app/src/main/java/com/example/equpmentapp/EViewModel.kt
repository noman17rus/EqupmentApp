package com.example.equpmentapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

open class EViewModel : ViewModel() {
    var name = MutableLiveData("")
    val dateOfStart = MutableLiveData("")

    fun editName(name: String) {
        this.name.value = name
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun parseDate(date: String): LocalDate? {
        return LocalDate.parse(date)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getEndOfDate(date: String, period: Int = 1): LocalDate? {
        when (period) {
            1 -> return parseDate(dateOfStart.value.toString())?.plusDays(365L)
        }
        return parseDate(dateOfStart.value.toString())
    }
}

