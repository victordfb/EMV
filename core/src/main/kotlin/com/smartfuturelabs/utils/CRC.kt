package com.smartfuturelabs.utils

fun crc16(byteArray: ByteArray): Int {
    val polynomial = 0x1021
    var output = 0xFFFF
    for (byte in byteArray) {
        for (i in 0..7) {
            val bit = (byte.toInt() shr 7 - i and 1) == 1
            val c15 = (output shr 15 and 1) == 1
            output = output shl 1
            if (c15 xor bit) {
                output = output xor polynomial
            }
        }
    }
    return output and 0xffff
}
