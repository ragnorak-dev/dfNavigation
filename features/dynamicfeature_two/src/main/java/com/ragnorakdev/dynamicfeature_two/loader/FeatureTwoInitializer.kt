package com.ragnorakdev.dynamicfeature_two.loader

import android.content.Context
import androidx.startup.Initializer

class FeatureTwoInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        FeatureTwoEntryPointsLoader()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return mutableListOf()
    }

}