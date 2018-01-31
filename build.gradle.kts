import org.gradle.configuration.project.ProjectConfigurationActionContainer
import org.gradle.kotlin.dsl.*

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        var vKotlin : String by extra
        vKotlin = "1.2.21"

        classpath("com.android.tools.build:gradle:3.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$vKotlin")
    }
}

apply { from("dependencies.gradle.kts") }
