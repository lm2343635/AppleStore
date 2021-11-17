plugins {
    kotlin("jvm") version "1.5.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.kevinsawicki:http-request:6.0")
    implementation("net.sf.json-lib:json-lib:2.4:jdk15")
}