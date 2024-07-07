package com.futurelabs.brcode.domain

class Email private constructor(
    private val content: String
) : PixKey() {
    override fun content() = this.content

    companion object {
        fun of(content: String): Email {
            return Email(content)
        }
    }
}
