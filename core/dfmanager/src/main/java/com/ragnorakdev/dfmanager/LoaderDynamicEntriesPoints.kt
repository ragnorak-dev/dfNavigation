package com.ragnorakdev.dfmanager

class LoaderDynamicEntriesPoints {
    fun execute(loaderPath: String) {
        val clazz = Class.forName(loaderPath)
        clazz.getConstructor().newInstance()
    }
}