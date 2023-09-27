plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = ApplicationId.applicationId
    compileSdk = 34

    defaultConfig {
        applicationId = ApplicationId.applicationId
        minSdk = 28
        targetSdk = 34
        versionCode = Releases.versionCode
        versionName = Releases.versionName

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
    dynamicFeatures += setOf(
        ModulesApp.feature1,
        ModulesApp.feature2,
        ModulesApp.feature3
    )
}

dependencies {

    implementation(UILibraries.activityCompose)
    api(KotlinLibraries.coreKtx)
    api(KotlinLibraries.lifecycleRuntime)
    api(platform(UILibraries.composeBom))
    api(UILibraries.composeUi)
    api(UILibraries.composeGraphics)
    api(UILibraries.composeTooling)
    api(UILibraries.composeMaterial3)
    testImplementation(TestingLibraries.jUnit)
    androidTestImplementation(TestingLibraries.jUnitAndroid)
    androidTestImplementation(TestingLibraries.espressoCore)
    androidTestImplementation(TestingLibraries.uiJunit)
    debugImplementation(TestingLibraries.uiTooling)
    debugImplementation(TestingLibraries.uiManifest)
}