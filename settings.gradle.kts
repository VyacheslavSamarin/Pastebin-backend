pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}

rootProject.name = "Pastebin-backend"
//include("api-gateway")
//include("auth")
include("generation")
include("paste")
//include("notification")
include("user")
//include("storage")
include("common")
