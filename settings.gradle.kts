plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "modcraft"

include(
    "client",
    "server",
    "modApi",
    "common"
)
