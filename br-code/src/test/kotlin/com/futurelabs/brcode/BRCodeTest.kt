package com.futurelabs.brcode

import com.futurelabs.brcode.builders.BRCodeBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class BRCodeTest {

    @Test
    fun `should generate valid pix qr code 100 reais for Victor Barbosa with CPF in Brasilia`() {
        val brCode = BRCodeBuilder.newBuilder()
            .setMerchantName("JOAO AMADO DE DEUS MERCADANTE JUNIOR")
            .setPixKey("810.887.830-66")
            .setCity("BRASILIA")
            .setValue("150")
            .build()
        assertEquals(
            "00020126330014BR.GOV.BCB.PIX0111810887830665204000053039865406150.005802BR5925JOAO AMADO DE DEUS MERCAD6008BRASILIA62070503***63040ACA",
            brCode.generateBRCode()
        )
    }

    @Test
    fun `should generate valid pix qr code 200 reais for Maria da Silva with CPF in Sao Paulo`() {
        val brCode = BRCodeBuilder.newBuilder()
            .setMerchantName("MARIA DA SILVA")
            .setPixKey("27033479018")
            .setCity("SAO PAULO")
            .setValue("200.20")
            .build()
        assertEquals(
            "00020126330014BR.GOV.BCB.PIX0111270334790185204000053039865406200.205802BR5914MARIA DA SILVA6009SAO PAULO62070503***63041D33",
            brCode.generateBRCode()
        )
    }
}
