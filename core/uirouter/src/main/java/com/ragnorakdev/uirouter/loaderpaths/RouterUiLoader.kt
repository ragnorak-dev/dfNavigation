package com.ragnorakdev.uirouter.loaderpaths

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.ProviderInfo
import android.os.Bundle
import android.os.Trace
import java.lang.ref.WeakReference

class RouterUiLoader(context: Context) {

    private val mContext: WeakReference<Context> = WeakReference(context)

    companion object {
        const val SECTION_NAME = "routerUI"
        private var sInstance: RouterUiLoader? = null
        private val sLock = Any()

        fun getInstance(context: Context): RouterUiLoader? {
            if (sInstance == null) {
                synchronized(sLock) {
                    if (sInstance == null) {
                        sInstance = RouterUiLoader(context)
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
                    RouterUiProvider::class.java.name
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
                        val clazz = Class.forName(moduleLoaderKey)
                        if (LoaderEntryViews::class.java.isAssignableFrom(clazz)) {
                            clazz.getConstructor().newInstance()
                        }
                    }
                } else {
                    val keys = providerMetadata.keySet()
                    for (key in keys) {
                        val clazz = Class.forName(key)
                        if (LoaderEntryViews::class.java.isAssignableFrom(clazz)) {
                            clazz.getConstructor().newInstance()
                        }
                    }
                }
            }
        } catch (exception: ClassNotFoundException) {
            throw exception
        }
    }
}