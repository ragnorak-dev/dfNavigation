package com.ragnorakdev.dfmanager

import android.content.Context
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory

class DynamicFeatureLoader(private val context: Context) {

    companion object {
        fun getInstance(context: Context): DynamicFeatureLoader = DynamicFeatureLoader(context)
    }

    private val splitInstallManager: SplitInstallManager by lazy {
        SplitInstallManagerFactory.create(context)
    }

    fun loadDynamicFeaturesInstalled(moduleName: String, modulePathLoader: String) {
        splitInstallManager.installedModules.find { it == moduleName}?.let {
            LoaderDynamicEntriesPoints().execute(modulePathLoader)
        }
    }
}