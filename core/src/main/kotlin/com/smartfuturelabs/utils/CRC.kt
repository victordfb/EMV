package com.smartfuturelabs.utils

fun crc16(byteArray: ByteArray): Int {
    val polynomial = 0x1021
    var result = 0xFFFF
    val bytes = byteArray
    for (b in bytes) {
        for (i in 0..7) {
            val bit = (b.toInt() shr 7 - i and 1) == 1
            val c15 = (result shr 15 and 1) == 1
            result = result shl 1
            if (c15 xor bit) {
                result = result xor polynomial
            }
        }
    }
    result = result and 0xffff
    return result
}
