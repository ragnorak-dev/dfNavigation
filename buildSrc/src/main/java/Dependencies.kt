import org.gradle.api.JavaVersion

object ApplicationId {
    const val applicationId = "com.ragnorakdev.ui_router"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val coreKtx = "1.12.0"
    const val lifecycleRuntime = "2.6.2"
    const val activityCompose = "1.7.2"
    const val composeBom = "2023.08.00"
    const val junit = "4.13.2"
    const val junitExt = "1.1.5"
    const val espressoCore = "3.5.1"
    const val koinCore = "3.5.0"
    const val koinAndroid = "3.5.0"
    const val koinCompose = "1.1.0"
}


object KotlinLibraries {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
}

object Libraries {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koinCore}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroid}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koinCompose}"
}

object UILibraries {
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composeTooling = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
}

object TestingLibraries {
    const val jUnit = "junit:junit:${Versions.junit}"
    const val jUnitAndroid = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val uiJunit = "androidx.compose.ui:ui-test-junit4"
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val uiManifest = "androidx.compose.ui:ui-test-manifest"
}

object ModulesApp {
    const val app = ":app"

    const val feature1 = ":features:dynamicfeature1"
    const val feature2 = ":features:dynamicfeature2"
    const val feature3 = ":features:dynamicfeature3"
    const val uiRouter = ":core:uirouter"
    const val dfManager = ":core:dfmanager"
}
