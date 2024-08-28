plugins {
    kotlin("jvm") version "2.0.0"
}

group = "io.github.cmsong111"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    // OkHttp
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
