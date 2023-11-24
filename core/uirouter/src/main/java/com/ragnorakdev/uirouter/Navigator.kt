package com.ragnorakdev.uirouter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ragnorakdev.uirouter.entryPointTypes.ActivityDynamicFeaturePath
import com.ragnorakdev.uirouter.entryPointTypes.ComposableDynamicFeaturePath

object Navigator {
    const val INFO_BUNDLE = "infoBundle"

    private val activitiesRoutes: HashMap<NavigationNameFeatures, EntryPointModule> = hashMapOf()

    fun addAEntryPointRoute(id: NavigationNameFeatures, route: EntryPointModule) {
        activitiesRoutes[id] = route
    }

    fun removeEntryPoint(id: NavigationNameFeatures) {
        activitiesRoutes.remove(id)
    }

    @Composable
    fun NavigationTo(
        to: NavigationNameFeatures,
        infoBundle: Bundle? = null,
        registerForActivityResult: ActivityResultLauncher<Intent>? = null
    ) {
        when {
            activitiesRoutes[to] is ActivityDynamicFeaturePath -> {
                navigateToDynamicFeature(
                    LocalContext.current,
                    (activitiesRoutes[to] as ActivityDynamicFeaturePath).dynamicFeaturePath,
                    infoBundle,
                    registerForActivityResult
                )
            }
            activitiesRoutes[to] is ComposableDynamicFeaturePath -> {
                GetComposeViewFromFeature(activitiesRoutes[to] as ComposableDynamicFeaturePath)
            }
        }
    }

    private fun navigateToDynamicFeature(
        context: Context,
        to: Class<out Activity>,
        infoBundle: Bundle? = null,
        registerForActivityResult: ActivityResultLauncher<Intent>? = null
    ) {
        val intent = Intent(context, to)
        infoBundle?.let {
            intent.putExtra(INFO_BUNDLE, it)
        }
        registerForActivityResult?.launch(intent) ?: context.startActivity(intent)
    }


    @Composable
    fun GetComposeViewFromFeature(to: ComposableDynamicFeaturePath, ) = to.methodNameView()
}