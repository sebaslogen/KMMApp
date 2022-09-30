import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("dev.icerock.moko.kswift")
}

version = "1.0"
object Versions {
    const val kermitVersion = "1.1.3"
    const val mokoVersion = "0.14.0"
    const val ktorVersion = "2.0.3"
    const val kotlinXDateTimeVersion = "0.4.0"
    const val koin = "3.2.0"
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "MultiPlatformLibrary"
            isStatic = false
            export("dev.icerock.moko:mvvm-core:${Versions.mokoVersion}")
            export("dev.icerock.moko:mvvm-flow:${Versions.mokoVersion}")
            export("dev.icerock.moko:mvvm-state:${Versions.mokoVersion}")
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
                api("co.touchlab:kermit:${Versions.kermitVersion}")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                api("dev.icerock.moko:resources:${Versions.mokoVersion}")
                api("dev.icerock.moko:mvvm-core:${Versions.mokoVersion}")
                api("dev.icerock.moko:mvvm-flow:${Versions.mokoVersion}")
                api("dev.icerock.moko:mvvm-flow-resources:${Versions.mokoVersion}")
                api("dev.icerock.moko:mvvm-state:${Versions.mokoVersion}")
//                implementation("io.ktor:ktor-client-core:${Versions.ktorVersion}")
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0-RC")
//                implementation("org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinXDateTimeVersion}")
//                implementation("io.insert-koin:koin-core:${Versions.koin}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("dev.icerock.moko:mvvm-test:${Versions.mokoVersion}")
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                api("dev.icerock.moko:mvvm-flow-compose:${Versions.mokoVersion}")
                api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
//                implementation("io.ktor:ktor-client-okhttp:${Versions.ktorVersion}")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
//            dependencies {
//                implementation("io.ktor:ktor-client-darwin:${Versions.ktorVersion}")
//                implementation("org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinXDateTimeVersion}")
//            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 23
        targetSdk = 33
    }
}

kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}