package com.futurelabs.brcode.domain

class Cpf private constructor(
    private val content: String
) : PixKey() {
    override fun content() = this.content

    companion object {
        fun of(content: String): Cpf {
            val cleanContent = content
                .replace(Regex("\\."), "")
                .replace(Regex("-"), "")
            return Cpf(cleanContent)
        }
    }
}
