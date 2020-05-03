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
    testImplementation(kotlin("test-junit5"))
    implementation(kotlin("stdlib-jdk8"))
}

application {
    mainClassName = "MainKt"
}
