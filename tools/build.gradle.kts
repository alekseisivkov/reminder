import javafx.util.Pair
import org.gradle.kotlin.dsl.*

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    val toolsDeps: MutableList<Pair<String, String>> by rootProject.extra
    toolsDeps.forEach { add(it.key, it.value) }
}

repositories {
    jcenter()
}