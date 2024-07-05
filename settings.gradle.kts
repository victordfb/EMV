plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "emv-brcode"
include("core")
include("br-code")
include("qrcode-gen")
