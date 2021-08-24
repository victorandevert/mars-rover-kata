plugins {
    kotlin("jvm") version "1.5.21"
}

group = "mars.rover.kata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.20.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
}

tasks.test {
    useJUnitPlatform()
}