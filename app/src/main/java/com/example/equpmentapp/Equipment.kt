package com.example.equpmentapp

import java.time.LocalDate

data class Equipment(
    val name: String,
    var period: Int,
    var startDate: LocalDate?,
    var endDate: LocalDate?
) {
}