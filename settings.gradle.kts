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
include(":features:dynamicfeature1")
include(":features:dynamicfeature2")
include(":features:dynamicfeature3")
include(":core:uirouter")
include(":core:dfmanager")
