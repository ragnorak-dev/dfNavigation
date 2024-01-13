pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "UI-Router"
include(":app")
include(":features:dynamicfeature_one")
include(":features:dynamicfeature_two")
include(":features:dynamicfeature_three")
include(":core:dfnavigator")