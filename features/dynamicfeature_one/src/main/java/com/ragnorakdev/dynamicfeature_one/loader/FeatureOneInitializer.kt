package com.ragnorakdev.dynamicfeature_one.loader

import android.content.Context
import androidx.startup.Initializer

class FeatureOneInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        FeatureOneEntryPointsLoader()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return mutableListOf()
    }

}