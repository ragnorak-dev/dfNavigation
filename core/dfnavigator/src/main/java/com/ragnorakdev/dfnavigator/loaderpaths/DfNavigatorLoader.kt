package com.ragnorakdev.dfnavigator.loaderpaths

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.ProviderInfo
import android.os.Bundle
import android.os.Trace
import java.lang.ref.WeakReference

class DfNavigatorLoader(context: Context) {

    private val mContext: WeakReference<Context> = WeakReference(context)

    companion object {
        const val SECTION_NAME = "dfNavigatorLoader"
        private var sInstance: DfNavigatorLoader? = null
        private val sLock = Any()

        fun getInstance(context: Context): DfNavigatorLoader? {
            if (sInstance == null) {
                synchronized(sLock) {
                    if (sInstance == null) {
                        sInstance = DfNavigatorLoader(context)
                    }
                }
            }
            return sInstance
        }
    }

    fun discoverAndInitialize(moduleName: String? = null) {
        try {
            mContext.get()?.let { context ->
                Trace.beginSection(SECTION_NAME)
                val provider = ComponentName(
                    context.packageName,
                    DfNavigatorProvider::class.java.name
                )
                val providerInfo: ProviderInfo = context.packageManager
                    .getProviderInfo(provider, PackageManager.GET_META_DATA)
                val metadata = providerInfo.metaData
                discoverAndInitialize(metadata, moduleName)
            }
        } catch (exception: PackageManager.NameNotFoundException) {
            throw exception
        } finally {
            Trace.endSection()
        }
    }

    private fun discoverAndInitialize(metadata: Bundle?, moduleName: String?) {
        try {
            metadata?.let { providerMetadata ->
                if (moduleName != null) {
                    val keys = providerMetadata.keySet()
                    val key = keys.filter { metadataKey ->
                        providerMetadata.getString(metadataKey) == moduleName
                    }
                    key.firstOrNull()?.let { moduleLoaderKey ->
                        instanceLoaderClass(moduleLoaderKey)
                    }
                } else {
                    val keys = providerMetadata.keySet()
                    for (key in keys) {
                        instanceLoaderClass(key)
                    }
                }
            }
        } catch (exception: ClassNotFoundException) {
            throw exception
        }
    }

    private fun instanceLoaderClass(loaderClassPath: String) {
        val clazz = Class.forName(loaderClassPath)
        if (LoaderDfNavigatorViews::class.java.isAssignableFrom(clazz)) {
            clazz.getConstructor().newInstance()
        }
    }
}