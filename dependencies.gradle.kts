import javafx.util.Pair
import org.gradle.kotlin.dsl.*
import java.util.*

var appDeps: MutableList<Pair<String, Any>> by extra
appDeps = ArrayList()

var utilDeps: MutableList<Pair<String, Any>> by extra
utilDeps = ArrayList()

var toolsDeps: MutableList<Pair<String, Any>> by extra
toolsDeps = ArrayList()

var entitiesDeps: MutableList<Pair<String, Any>> by extra
entitiesDeps = ArrayList()

var interactorDeps: MutableList<Pair<String, Any>> by extra
interactorDeps = ArrayList()

var managersDeps: MutableList<Pair<String, Any>> by extra
managersDeps = ArrayList()


//global versions
var vBuildTools: String by extra
vBuildTools = "27.0.0"
var vCompileSdk: Int by extra
vCompileSdk = 27
var vMinSdk: Int by extra
vMinSdk = 21
var vTargetSdk: Int by extra
vTargetSdk = 27
val vKotlin: String by extra


//modules
private val app = ":app"
private val managers = ":managers"
private val interactors = ":interactors"
private val entities = ":entities"
private val utils = ":utils"
private val tools = ":tools"

// versions
private val vPlayServices = "11.0.1"
private val vSupport = "27.0.2"
private val vDagger = "2.14.1"
private val vGson = "2.8.0"
private val vConstraint = "1.0.2"
private val vLifecycle = "1.1.0"
private val vCoroutines = "0.21"
private val vFirebase = "11.8.0"
private val vCicerone = "3.0.0"


//libs
private val appCompat = "com.android.support:appcompat-v7:$vSupport"
private val design = "com.android.support:design:$vSupport"
private val annotations = "com.android.support:support-annotations:$vSupport"
private val recyclerView = "com.android.support:recyclerview-v7:$vSupport"
private val supportAndroid = "com.android.support:support-v4:$vSupport"
private val constraintLayout = "com.android.support.constraint:constraint-layout:$vConstraint"

private val firebase = "com.google.firebase:firebase-core:$vFirebase"
private val firestore = "com.google.firebase:firebase-firestore:$vFirebase"

private val cicerone = "ru.terrakok.cicerone:cicerone:$vCicerone"

private val lifecycle = "android.arch.lifecycle:extensions:$vLifecycle"
private val lifecycleCompiler = "android.arch.lifecycle:compiler:$vLifecycle"

private val dagger = "com.google.dagger:dagger:$vDagger"
private val daggerCompiler = "com.google.dagger:dagger-compiler:$vDagger"
private val daggerAndroid = "com.google.dagger:dagger-android-support:$vDagger"
private val daggerAndroidCompiler = "com.google.dagger:dagger-android-processor:$vDagger"

private val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jre7:$vKotlin"
private val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$vCoroutines"


//configuration
private val impl = "implementation"
private val kapt = "kapt"


//app deps
appDeps.add(impl, project(interactors))
appDeps.add(impl, project(entities))
appDeps.add(impl, project(utils))
appDeps.add(impl, project(tools))

appDeps.add(impl, appCompat)
appDeps.add(impl, design)
appDeps.add(impl, annotations)
appDeps.add(impl, recyclerView)
appDeps.add(impl, supportAndroid)
appDeps.add(impl, constraintLayout)

appDeps.add(impl, cicerone)

appDeps.add(impl, lifecycle)
appDeps.add(kapt, lifecycleCompiler)

appDeps.add(impl, dagger)
appDeps.add(kapt, daggerCompiler)
appDeps.add(impl, daggerAndroid)
appDeps.add(kapt, daggerAndroidCompiler)

appDeps.add(impl, kotlin)
appDeps.add(impl, coroutines)


//interactors deps
interactorDeps.add(impl, project(entities))
interactorDeps.add(impl, project(tools))

interactorDeps.add(impl, kotlin)

interactorDeps.add(impl, dagger)
interactorDeps.add(kapt, daggerCompiler)


//managers deps
managersDeps.add(impl, project(interactors))
managersDeps.add(impl, project(entities))
managersDeps.add(impl, project(utils))
managersDeps.add(impl, project(tools))
managersDeps.add(impl, kotlin)

managersDeps.add(impl, dagger)
managersDeps.add(kapt, daggerCompiler)

managersDeps.add(impl, firebase)
managersDeps.add(impl, firestore)


//entities deps
entitiesDeps.add(impl, kotlin)


//tools deps
toolsDeps.add(impl, kotlin)


//utils deps
utilDeps.add(impl, kotlin)

fun MutableList<Pair<String, Any>>.add(config: String, dep: Any) {
    add(Pair(config, dep))
}
