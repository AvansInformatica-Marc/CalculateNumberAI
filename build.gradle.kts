plugins {
    kotlin("jvm") version "1.4-M1"
    application
}

group = "nl.marc"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test-junit"))
}

application {
    mainClassName = "nl.marc.MainKt"
}
