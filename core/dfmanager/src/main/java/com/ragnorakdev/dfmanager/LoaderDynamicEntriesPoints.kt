package com.ragnorakdev.dfmanager

import android.content.Context

class LoaderDynamicEntriesPoints {
    fun execute(context: Context, featureId: DynamicFeaturesLoadersNames) {
        val clazz = context.classLoader.loadClass(featureId.loaderPath)
        clazz.newInstance()
    }
}