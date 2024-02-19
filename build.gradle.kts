import java.util.Properties

plugins {
    kotlin("jvm") version "1.9.22"
}

repositories {
    mavenCentral()
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

val semverVersion = "1.4.2"

project(":client") {
    dependencies {
        implementation(project(":common"))
        implementation(project(":modApi"))
        implementation(project(":server"))
    }
}

project(":server") {
    dependencies {
        implementation(project(":common"))
        implementation(project(":modApi"))
    }
}

project(":modApi") {
    dependencies {
        api("io.github.z4kn4fein:semver:$semverVersion")
        implementation(project(":common"))
    }

    tasks.register("generateModProperties") {
        doLast {
            val properties = Properties()
            properties["name"] = Mod.INSTANCE.name
            properties["description"] = Mod.INSTANCE.description
            properties["modId"] = Mod.INSTANCE.modId
            properties["version"] = Mod.INSTANCE.version
            properties["dependencies"] = Mod.INSTANCE.dependencies
            properties["incompatabilities"] = Mod.INSTANCE.incompatabilities

            File("${layout.buildDirectory}/resources/mod.properties").outputStream().use { properties.store(it, null) }
        }
    }

    tasks.named("build") {
        dependsOn("generateModProperties")
    }
}

kotlin {
    jvmToolchain(21)
}