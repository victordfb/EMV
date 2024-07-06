package com.futurelabs.qrcode.gui

import com.futurelabs.brcode.builders.BRCodeBuilder
import com.futurelabs.qrcode.QRCodeGenerator
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

const val BASE_DIR = "./qrcode-gen/qr_codes"

class PixImageGeneratorController {

    private val fileName: String = "qr_code.png"
    lateinit var action: (url: String) -> Unit?

    init {
        this.copyWaitingImg()
    }

    fun generateQRCodeImage(pixKey: String, name: String, city: String, value: String) {
        val imageUrl = this.imageUrl()
        val brCode = BRCodeBuilder.newBuilder()
            .setValue(value)
            .setMerchantName(name)
            .setPixKey(pixKey)
            .setCity(city)
            .build()
        val generator = QRCodeGenerator(brCode, imageUrl, 350)
        generator.generate()
        this.action(imageUrl)
    }

    fun onQRCodeUpdate(action: (url: String) -> Unit) {
        val firstCall = !this::action.isInitialized
        this.action = action
        if (firstCall) this.action(this.imageUrl())
    }

    private fun imageUrl(): String = "${BASE_DIR}/$fileName"

    private fun copyWaitingImg() {
        val resourceFileName = "waiting.jpg"
        val loader = PixImageGeneratorController::class.java.classLoader
        val resourceAsStream = loader.getResourceAsStream(resourceFileName)
        if (resourceAsStream == null) {
            println("Resource not found: $resourceFileName")
            return
        } else {
            val destinationFile = File(this.imageUrl())
            destinationFile.parentFile.mkdirs()
            Files.copy(resourceAsStream, destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
        }
    }
}
