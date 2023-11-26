plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.ragnorakdev.dynamicfeature_two"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(ModulesApp.app))
    implementation(project(ModulesApp.uiRouter))

    implementation(UILibraries.activityCompose)
    implementation(KotlinLibraries.coreKtx)
    implementation(KotlinLibraries.lifecycleRuntime)
    implementation(platform(UILibraries.composeBom))
    implementation(UILibraries.composeUi)
    implementation(UILibraries.composeGraphics)
    implementation(UILibraries.composeTooling)
    implementation(UILibraries.composeMaterial3)
    implementation(Libraries.koinCore)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCompose)
    implementation(Libraries.startupRuntime)
    testImplementation(TestingLibraries.jUnit)
    androidTestImplementation(TestingLibraries.jUnitAndroid)
    androidTestImplementation(TestingLibraries.espressoCore)
    androidTestImplementation(TestingLibraries.composeJunit)
    debugImplementation(TestingLibraries.uiTooling)
    debugImplementation(TestingLibraries.uiManifest)
}