import javafx.util.Pair
import org.gradle.kotlin.dsl.*
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.script.lang.kotlin.*
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    val vBuildTools : String by rootProject.extra
    val vCompileSdk: Int by rootProject.extra
    val vMinSdk: Int by rootProject.extra
    val vTargetSdk: Int by rootProject.extra


    buildToolsVersion(vBuildTools)
    compileSdkVersion(vCompileSdk)

    defaultConfig {
        minSdkVersion(vMinSdk)
        targetSdkVersion(vTargetSdk)

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

dependencies {
    val appDeps: MutableList<Pair<String, String>> by rootProject.extra
    appDeps.forEach { add(it.key, it.value) }
}

repositories {
    jcenter()
    google()
}

apply {
    plugin("com.google.gms.google-services")
}