package com.smartfuturelabs.utils

/**
 * Information technology—Telecommunications and information exchange between
 * systems—High-level data link control (HDLC) procedures.
 *
 * The checksum shall be calculated according to [ISO/IEC 13239] using the
 * polynomial '1021' (hex) and initial value 'FFFF' (hex).
 *
 * Implements CRC-16/CCITT-FALSE
 *
 * @see "https://en.wikipedia.org/wiki/Cyclic_redundancy_check"
 *
 * @param byteArray
 * @return CRC16 integer
 */
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
