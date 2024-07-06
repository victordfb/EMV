package com.futurelabs.brcode.domain

abstract class AbstractMaxLengthCode(
    private val content: String,
    private val maxLengthCode: Int
) {
    fun truncatedContent(): String = this.content.take(maxLengthCode)
}