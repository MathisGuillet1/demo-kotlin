package com.qlik.demo.kotlin.solution.idiomatic.model

enum class SeatOption(val optionName: String) {
    FIRST_CLASS("First Class"),
    ECONOMY("Economy");

    companion object {
        fun get(optionName: String): SeatOption? =
            entries.firstOrNull { it.optionName == optionName }
    }
}