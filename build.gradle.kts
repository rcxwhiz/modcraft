plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.joshbedwell"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // LWJGL3 bindings
    val lwjglVersion = "3.3.3"
    val lwjglNatives = listOf("natives-windows", "natives-linux", "natives-macos", "natives-macos-arm64")  // TODO this should dynamically choose natives?

    // JVM modules
    val lwjglModules = listOf("glfw", "openal", "opengl", "vulkan")
    for(module in lwjglModules) {
        implementation("org.lwjgl:lwjgl-$module:${lwjglVersion}")
    }

    // Modules that needs native libs
    val lwjglNativeModules = listOf("glfw", "openal", "opengl")
    for(module in lwjglNativeModules) {
        for(native in lwjglNatives)
            runtimeOnly("org.lwjgl:lwjgl-$module:${lwjglVersion}:$native")
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}