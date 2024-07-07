package com.futurelabs.brcode.domain

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

private val REGEX = Regex("^[0-9]+(\\.[0-9]{2})?$")

class Brl private constructor(
    private val value: BigDecimal
) {
    fun asString(): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        numberFormat.minimumFractionDigits = 2
        numberFormat.maximumFractionDigits = 2
        return numberFormat.format(this.value).replace(",", "")
    }

    companion object {
        fun of(value: String) = if (REGEX.matches(value)) Brl(BigDecimal(value)) else null
    }
}
