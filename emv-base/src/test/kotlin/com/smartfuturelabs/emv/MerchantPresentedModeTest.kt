package com.smartfuturelabs.emv

import com.smartfuturelabs.emvcore.BasicDataObject
import com.smartfuturelabs.emvcore.ComposedDataObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MerchantPresentedModeTest {

    @Test
    fun testIt() {
        val merchantPresentedMode = MerchantPresentedMode()
        merchantPresentedMode.addDataObject(BasicDataObject("00", "01")) // Payload Info Indicator
        val merchantAccountInformation = ComposedDataObject("26")
        merchantAccountInformation.add(BasicDataObject("00", "BR.GOV.BCB.PIX"))
        merchantAccountInformation.add(BasicDataObject("01", "07681145605"))
        merchantPresentedMode.addDataObject(merchantAccountInformation) // Merchant Account Info
        merchantPresentedMode.addDataObject(BasicDataObject("52", "0000")) // Merchant Category Code
        merchantPresentedMode.addDataObject(BasicDataObject("53", "986")) // Transaction currency
        merchantPresentedMode.addDataObject(BasicDataObject("58", "BR")) // Country Code
        merchantPresentedMode.addDataObject(BasicDataObject("59", "VICTOR DOLIRIO FERREIRA B")) // Merchant Name
        merchantPresentedMode.addDataObject(BasicDataObject("60", "BRASILIA")) // Merchant City
        val additionalDataField = ComposedDataObject("62")
        additionalDataField.add(BasicDataObject("05", "***")) // Reference Label (ID da transacao)
        merchantPresentedMode.addDataObject(additionalDataField) //Aditional Data Field Template

        assertEquals(
            "00020126330014BR.GOV.BCB.PIX0111076811456055204000053039865802BR5925VICTOR DOLIRIO FERREIRA B6008BRASILIA62070503***63044DD5",
            merchantPresentedMode.generateCode()
        )
    }
}
