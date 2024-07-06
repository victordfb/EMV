# EMV--BR_Code

[![AGPL License](https://img.shields.io/badge/License-AGPL%20v3-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)

## Description

Implements EMV encoder and decoder. Also available a BRCode implementation for Brazilian PIX QR-Code generation.

Compatible with Java and Kotlin. 

## Features

- EMV Implementation
- BR Code - PIX QR Code generator
- Simple desktop app for testing purposes

## Example Usage

```Kotlin
// Example of PIX QR Code generation
val brCode = BRCodeBuilder.newBuilder()
            .setMerchantName("MARIA DA SILVA")
            .setPixKey("27033479018")
            .setCity("SAO PAULO")
            .setValue("200.20")
            .build()
val generator = QRCodeGenerator(brCode, "./qr_code.png", 350)
generator.generate()
