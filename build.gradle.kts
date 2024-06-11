plugins {
    id("org.springframework.boot") version "3.3.0"
    kotlin("jvm") version "1.9.22"
}

group = "ru.gazprombank"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.0")
    implementation("org.springframework.boot:spring-boot-starter-actuator:3.3.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}