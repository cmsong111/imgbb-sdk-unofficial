import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm") version "2.0.0"
    id("com.vanniktech.maven.publish") version "0.29.0"
}

group = "io.github.cmsong111"
version = "0.0.2"

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

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}

mavenPublishing {
    coordinates(group.toString(), rootProject.name, version.toString())

    pom {
        name.set(rootProject.name)
        description.set("An unofficial ImgBB API client for Kotlin")
        inceptionYear.set("2024")
        url.set("https://github.com/cmsong111/imgbb-sdk-unofficial")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("cmsong111")
                name.set("Namju Kim")
                url.set("https://github.com/cmsong111/")
            }
        }
        scm {
            url.set("https://github.com/cmsong111/imgbb-sdk-unofficial")
            connection.set("scm:git:git://github.com/cmsong111/imgbb-sdk-unofficial.git")
            developerConnection.set("scm:git:ssh://git@github.com/cmsong111/imgbb-sdk-unofficial.git")
        }
    }
}
