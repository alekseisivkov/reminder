import javafx.util.Pair
import org.gradle.kotlin.dsl.*
import java.util.*

var appDeps: MutableList<Pair<String, String>> by extra
appDeps = ArrayList()

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


// versions
private val vPlayServices = "11.0.1"
private val vSupport = "27.0.2"
private val vDagger = "2.14.1"
private val vGson = "2.8.0"
private val vConstraint = "1.0.2"
private val vRoom = "1.0.0"
private val vCoroutines = "0.21"


//libs
private val appCompat = "com.android.support:appcompat-v7:$vSupport"
private val design = "com.android.support:design:$vSupport"
private val annotations = "com.android.support:support-annotations:$vSupport"
private val recyclerView = "com.android.support:recyclerview-v7:$vSupport"
private val supportAndroid = "com.android.support:support-v4:$vSupport"
private val constraintLayout = "com.android.support.constraint:constraint-layout:$vConstraint"

private val room = "android.arch.persistence.room:runtime:$vRoom"
private val roomProcessor = "android.arch.persistence.room:compiler:$vRoom"

private val dagger = "com.google.dagger:dagger:$vDagger"
private val daggerCompiler = "com.google.dagger:dagger-compiler:$vDagger"

private val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jre7:$vKotlin"
private val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$vCoroutines"


//configuration
private val impl = "implementation"
private val kapt = "kapt"


//app deps
appDeps.add(impl, appCompat)
appDeps.add(impl, design)
appDeps.add(impl, annotations)
appDeps.add(impl, recyclerView)
appDeps.add(impl, supportAndroid)
appDeps.add(impl, constraintLayout)

appDeps.add(impl, room)
appDeps.add(kapt, roomProcessor)

appDeps.add(impl, dagger)
appDeps.add(kapt, daggerCompiler)

appDeps.add(impl, kotlin)
appDeps.add(impl, coroutines)

fun MutableList<Pair<String, String>>.add(config: String, dep: String) {
    add(Pair(config, dep))
}
