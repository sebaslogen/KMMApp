plugins {
    id("com.android.application")
    kotlin("android")
}

// Dependencies versions
val composeCompiler = "1.3.1"
val composeUI = "1.2.1"
val activityCompose = "1.5.1"
val viewModelCompose = "2.5.1"

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.sebaslogen.kmmapp.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures { // Enables Jetpack Compose for this module
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeCompiler
    }
}

dependencies {
    implementation(project(":MultiPlatformLibrary"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.compose.compiler:compiler:$composeCompiler")
    implementation("androidx.compose.foundation:foundation:$composeUI")
    implementation("androidx.compose.material:material:$composeUI")
    implementation("androidx.compose.runtime:runtime:$composeUI")
    implementation("androidx.compose.ui:ui:$composeUI")
    implementation("androidx.compose.ui:ui-tooling:$composeUI")
    implementation("androidx.activity:activity-compose:$activityCompose")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$viewModelCompose")
}