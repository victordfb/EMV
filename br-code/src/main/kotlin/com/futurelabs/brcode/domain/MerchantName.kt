package com.futurelabs.brcode.domain

private const val DEFAULT_NAME_SIZE = 25

class MerchantName(name: String) : AbstractMaxLengthCode(name, DEFAULT_NAME_SIZE)
