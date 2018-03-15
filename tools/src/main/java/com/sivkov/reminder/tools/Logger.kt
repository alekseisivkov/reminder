package com.sivkov.reminder.tools

import kotlin.reflect.KClass

interface Logger {

    val defaultTag: String

    fun <T: Any> generateTag(clazz: KClass<T>): String = clazz.java.simpleName

    fun d(tag: String = defaultTag, message: String)

    fun w(tag: String = defaultTag, message: String)

    fun e(tag: String = defaultTag, message: String, error: Throwable? = null)


}