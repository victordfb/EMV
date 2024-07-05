package com.futurelabs.brcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal


class BRCodeTest {

    @Test
    fun `should generate valid pix qr code 100 reais for Victor Barbosa with CPF in Brasilia`() {
        val brCode = BRCode(BigDecimal("150"), "VICTOR DOLIRIO FERREIRA B", "07681145605", "BRASILIA")
        assertEquals(
            "00020126330014BR.GOV.BCB.PIX0111076811456055204000053039865406150.005802BR5925VICTOR DOLIRIO FERREIRA B6008BRASILIA62070503***630494D7",
            brCode.generateBRCode()
        )
    }

    @Test
    fun `should generate valid pix qr code 200 reais for Maria da Silva with CPF in Sao Paulo`() {
        val brCode = BRCode(BigDecimal("200"), "MARIA DA SILVA", "27033479018", "SAO PAULO")
        assertEquals(
            "00020126330014BR.GOV.BCB.PIX0111270334790185204000053039865406200.005802BR5914MARIA DA SILVA6009SAO PAULO62070503***630435DC",
            brCode.generateBRCode()
        )
    }
}
