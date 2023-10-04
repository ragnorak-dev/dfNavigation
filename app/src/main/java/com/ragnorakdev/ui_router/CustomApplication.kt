package com.ragnorakdev.ui_router

import android.app.Application
import com.ragnorakdev.dfmanager.DynamicFeatureLoader
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CustomApplication)
        }

        DynamicFeaturesLoadersNames.entries.forEach {
            DynamicFeatureLoader.getInstance(this)
                .loadDynamicFeaturesInstalled(moduleName = it.moduleName, modulePathLoader = it.loaderPath)
        }
    }
}