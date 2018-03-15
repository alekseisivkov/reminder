import javafx.util.Pair
import org.gradle.kotlin.dsl.*
import org.gradle.script.lang.kotlin.*
import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    id("java")
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val interactorDeps: MutableList<Pair<String, String>> by rootProject.extra
    interactorDeps.forEach { add(it.key, it.value) }
}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

repositories {
    jcenter()
}