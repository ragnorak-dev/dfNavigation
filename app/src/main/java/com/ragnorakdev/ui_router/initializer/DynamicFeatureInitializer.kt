package com.ragnorakdev.ui_router.initializer

import android.content.Context
import androidx.startup.Initializer
import com.ragnorakdev.dfmanager.DynamicFeatureLoader
import com.ragnorakdev.ui_router.DynamicFeaturesLoadersNames

class DynamicFeatureInitializer  : Initializer<Unit> {
    override fun create(context: Context) {
        DynamicFeaturesLoadersNames.entries.forEach {
            DynamicFeatureLoader.getInstance(context)
                .loadDynamicFeaturesInstalled(moduleName = it.moduleName, modulePathLoader = it.loaderPath)
        }
    }
    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }

}