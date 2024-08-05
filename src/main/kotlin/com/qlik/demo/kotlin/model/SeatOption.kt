package com.qlik.demo.kotlin.model

enum class SeatOption(val optionName: String) {
    FIRST_CLASS("First Class"),
    ECONOMY("Economy");

    companion object {
        fun from(optionName: String): SeatOption? =
            entries.firstOrNull { it.optionName == optionName }
    }
}