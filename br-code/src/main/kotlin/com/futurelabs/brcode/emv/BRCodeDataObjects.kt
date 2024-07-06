package com.futurelabs.brcode.emv

import com.futurelabs.brcode.domain.Brl
import com.futurelabs.brcode.domain.MerchantCity
import com.futurelabs.brcode.domain.MerchantName
import com.futurelabs.brcode.domain.PixKey
import com.smartfuturelabs.emvcore.BasicDataObject

private const val BCB_CODE = "BR.GOV.BCB.PIX"


// Additional Merchant Account Information
class BCBCode : BasicDataObject("00", BCB_CODE)

// Country Code
class BrazilCode : BasicDataObject("58", "BR")

// Merchant Category Code
class MerchantCategoryCode : BasicDataObject("52", "0000")

// Transaction currency
class TransactionCurrencyCode : BasicDataObject("53", "986")

// Merchant name
class MerchantNameCode(merchantName: MerchantName) : BasicDataObject("59", merchantName.truncatedContent())

// Additional Merchant Account Information
class PixKeyCode(pixKey: PixKey) : BasicDataObject("01", pixKey.content())

// Merchant City
class MerchantCityCode(merchantCity: MerchantCity) : BasicDataObject("60", merchantCity.truncatedContent())

// Transaction value
class BrlCode(brl: Brl) : BasicDataObject("54", brl.asString())
