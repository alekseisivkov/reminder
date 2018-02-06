import javafx.util.Pair
import org.gradle.kotlin.dsl.*

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    val interactorDeps: MutableList<Pair<String, String>> by rootProject.extra
    interactorDeps.forEach { add(it.key, it.value) }
}

repositories {
    jcenter()
}