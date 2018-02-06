import javafx.util.Pair
import org.gradle.kotlin.dsl.*

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    val entitiesDeps: MutableList<Pair<String, String>> by rootProject.extra
    entitiesDeps.forEach { add(it.key, it.value) }
}

repositories {
    jcenter()
}