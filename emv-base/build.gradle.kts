plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.smartfuturelab"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":core"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}