plugins {
    kotlin("jvm") version "1.3.72"
    application
}

group = "nl.marc"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test-junit"))
}

application {
    mainClassName = "nl.marc.MainKt"
}

tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to "nl.marc.MainKt"))
    }
}
