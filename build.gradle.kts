plugins {
    kotlin("jvm") version "1.9.22"
}

subprojects {
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    group = "com.joshbedwell"
    version = "0.1.0"

    dependencies {
        testImplementation("org.jetbrains.kotlin:kotlin-test")
    }
    tasks.test {
        useJUnitPlatform()
    }
}

project(":client") {
    dependencies {
        implementation(project(":common"))
        implementation(project(":mod-api"))
        implementation(project(":server"))
    }
}

project(":server") {
    dependencies {
        implementation(project(":common"))
        implementation(project(":mod-api"))
    }
}

project(":mod-api") {
    dependencies {
        implementation(project(":common"))
    }
}

kotlin {
    jvmToolchain(21)
}