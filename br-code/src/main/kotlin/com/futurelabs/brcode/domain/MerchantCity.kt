package com.futurelabs.brcode.domain

private const val DEFAULT_NAME_SIZE = 15

class MerchantCity(name: String) : AbstractMaxLengthCode(name, DEFAULT_NAME_SIZE)
