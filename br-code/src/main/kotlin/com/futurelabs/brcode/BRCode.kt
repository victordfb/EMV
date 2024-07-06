package com.futurelabs.brcode

import com.futurelabs.brcode.domain.Brl
import com.futurelabs.brcode.domain.MerchantCity
import com.futurelabs.brcode.domain.MerchantName
import com.futurelabs.brcode.domain.PixKey
import com.futurelabs.brcode.emv.*
import com.smartfuturelabs.emv.MerchantPresentedMode
import com.smartfuturelabs.emvcore.BasicDataObject
import com.smartfuturelabs.emvcore.ComposedDataObject


class BRCode(
    private val merchantName: MerchantName,
    private val pixKey: PixKey,
    private val city: MerchantCity,
    private val brl: Brl?,
) {
    fun generateBRCode(): String {
        val merchantPresentedMode = MerchantPresentedMode()
        merchantPresentedMode.addDataObject(BasicDataObject("00", "01")) // Payload Info Indicator
        val merchantAccountInformation = ComposedDataObject("26")
        merchantAccountInformation.add(BCBCode())
        merchantAccountInformation.add(PixKeyCode(pixKey))
        merchantPresentedMode.addDataObject(merchantAccountInformation)
        merchantPresentedMode.addDataObject(TransactionCurrencyCode())
        merchantPresentedMode.addDataObject(MerchantCategoryCode())
        if (this.brl != null) merchantPresentedMode.addDataObject(BrlCode(this.brl))
        merchantPresentedMode.addDataObject(BrazilCode())
        merchantPresentedMode.addDataObject(MerchantNameCode(this.merchantName))
        merchantPresentedMode.addDataObject(MerchantCityCode(city))
        val additionalDataField = ComposedDataObject("62")
        additionalDataField.add(BasicDataObject("05", "***")) // Reference Label (ID da transacao)
        merchantPresentedMode.addDataObject(additionalDataField) //Aditional Data Field Template
        return merchantPresentedMode.generateCode()
    }
}
