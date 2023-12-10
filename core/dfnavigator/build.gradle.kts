plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ragnorakdev.dfnavigator"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(KotlinLibraries.coreKtx)
    implementation(KotlinLibraries.activityKtx)
    implementation(UILibraries.composeRuntime)
    implementation(platform(UILibraries.composeBom))
    implementation(UILibraries.composeUi)
    implementation(UILibraries.composeGraphics)
    implementation(UILibraries.composeTooling)
    implementation(UILibraries.composeMaterial3)

    testImplementation(TestingLibraries.jUnit)
}