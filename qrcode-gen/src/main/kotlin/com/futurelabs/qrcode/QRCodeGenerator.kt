package com.futurelabs.qrcode

import com.futurelabs.brcode.BRCode
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import java.io.IOException
import java.math.BigDecimal
import java.nio.file.FileSystems
import java.nio.file.Path

class QRCodeGenerator(
    private val brCode: BRCode,
    private val filePath: String,
    private val size: Int
) {

    fun generate() {
        val qrCodeStr = this.brCode.generateBRCode()
        println(qrCodeStr)
        generateQRCodeImage(qrCodeStr, this.size, this.size, this.filePath)
    }

    @Throws(WriterException::class, IOException::class)
    fun generateQRCodeImage(text: String, width: Int, height: Int, filePath: String) {
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix: BitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height)
        val path: Path = FileSystems.getDefault().getPath(filePath)
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path)
    }
}

fun main() {
    val brCode =  BRCode(BigDecimal("150"), "MARIA DA SILVA", "27033479018", "SAO PAULO")
    val generator = QRCodeGenerator(brCode, "./qr_code.png", 350)
    generator.generate()
}
