package com.futurelabs.brcode

import com.smartfuturelabs.emv.MerchantPresentedMode
import com.smartfuturelabs.emvcore.BasicDataObject
import com.smartfuturelabs.emvcore.ComposedDataObject

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*


private const val BCB_CODE = "BR.GOV.BCB.PIX"

class BRCode(
    private val value: BigDecimal,
    private val name: String,
    private val pixKey: String,
    private val city: String,
) {
    fun generateBRCode(): String {
        val merchantPresentedMode = MerchantPresentedMode()
        merchantPresentedMode.addDataObject(BasicDataObject("00", "01")) // Payload Info Indicator
        val merchantAccountInformation = ComposedDataObject("26")
        merchantAccountInformation.add(BasicDataObject("00", BCB_CODE))
        merchantAccountInformation.add(BasicDataObject("01", this.pixKey))
        merchantPresentedMode.addDataObject(merchantAccountInformation) // Merchant Account Info
        merchantPresentedMode.addDataObject(BasicDataObject("52", "0000")) // Merchant Category Code
        merchantPresentedMode.addDataObject(BasicDataObject("53", "986")) // Transaction currency
        merchantPresentedMode.addDataObject(BasicDataObject("54", this.valueToStr())) // Transaction currency
        merchantPresentedMode.addDataObject(BasicDataObject("58", "BR")) // Country Code
        merchantPresentedMode.addDataObject(BasicDataObject("59", this.name)) // Merchant Name
        merchantPresentedMode.addDataObject(BasicDataObject("60", this.city)) // Merchant City
        val additionalDataField = ComposedDataObject("62")
        additionalDataField.add(BasicDataObject("05", "***")) // Reference Label (ID da transacao)
        merchantPresentedMode.addDataObject(additionalDataField) //Aditional Data Field Template
        return merchantPresentedMode.generateCode()
    }

    private fun valueToStr(): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        numberFormat.minimumFractionDigits = 2
        numberFormat.maximumFractionDigits = 2
        return numberFormat.format(this.value)
    }
}
