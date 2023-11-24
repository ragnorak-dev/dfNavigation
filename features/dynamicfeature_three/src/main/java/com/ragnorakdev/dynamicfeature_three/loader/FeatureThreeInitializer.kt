package com.ragnorakdev.dynamicfeature_three.loader

import android.content.Context
import androidx.startup.Initializer

class FeatureThreeInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        FeatureThreeEntryPointsLoader()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return mutableListOf()
    }

}