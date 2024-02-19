package com.joshbedwell.modcraft.modApi

import io.github.z4kn4fein.semver.Version

@JvmInline
value class ModID(val id: String)

data class Dependency(val modId: ModID, val minVersion: Version, val maxVersion: Version? = null)

interface ModMetadata {
    val name: String
    val description: String
    val modId: ModID
    val version: Version
    val dependencies: List<Dependency>
    val incompatibilities: List<ModID>
}