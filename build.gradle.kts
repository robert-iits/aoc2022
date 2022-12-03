plugins {
    kotlin("jvm") version "1.7.22"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
}

tasks {
    wrapper {
        gradleVersion = "8.0"
    }
}
