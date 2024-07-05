package com.smartfuturelabs.emv

import com.smartfuturelabs.utils.crc16


class MerchantPresentedMode {

    private val dataObjects = mutableListOf<DataObject>()

    fun addDataObject(dataObject: DataObject) {
        this.dataObjects.add(dataObject)
    }

    fun generateCode(): String {
        val code = this.dataObjects.joinToString(separator = "") { it.generateCode() } + "6304"
        val crc16 = crc16(code.toByteArray())
        val crcCode = String.format("%04X", crc16)
        return "$code$crcCode"
    }
}
